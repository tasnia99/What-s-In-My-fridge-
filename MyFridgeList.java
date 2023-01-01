package com.example.designpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.SnapshotHolder;

import java.util.ArrayList;
import java.util.List;

public class MyFridgeList extends AppCompatActivity {

    EditText ItemName,qty,exp,et_update_ItemName,et_update_Quantity,et_update_Expired;
    Button add,btn_update,btn_cancel,btn_show;
    RecyclerView recyclerView;
    MyAdapter adapter;
    DatabaseReference reference;
    FirebaseDatabase rootNode;

    List<user> list = new ArrayList<>();

    AlertDialog.Builder builder;

    AlertDialog dialog;

    String e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fridge_list);



        ItemName =  findViewById(R.id.ItemName);
        qty =  findViewById(R.id.qty);
        exp =  findViewById(R.id.exp);

        add =  findViewById(R.id.btn_add);

        recyclerView =  findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);

             add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                reference= rootNode.getReference("Items");

                e1 = ItemName.getText().toString();
                e2 = qty.getText().toString();
                e3 = exp.getText().toString();
               Helperclass1 helperclass1=new Helperclass1(e1,e2,e3);
               reference.child(e1).setValue(helperclass1);


                      user userData=new user();
                           userData.setName(e1);
                           userData.setQuantity(e2);
                           userData.setExpired(e3);
                           list.add(userData);
                          exp.setText("");
                          ItemName.setText("");
                          qty.setText("");
                          adapter.notifyDataSetChanged();
                          Toast.makeText(MyFridgeList.this,"Item Add Success...",Toast.LENGTH_SHORT).show();




            }
        });


        adapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(final int position, user userData) {

                builder = new AlertDialog.Builder(MyFridgeList.this);
                builder.setTitle("Update Item Info");
                builder.setCancelable(true);
                View view = LayoutInflater.from(MyFridgeList.this).inflate(R.layout.dialouge,null,true);
                InitUpdateDialog(position,view);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();
            }
        });


    }

    private void InitUpdateDialog(final int position, View view) {

        et_update_ItemName= view.findViewById(R.id.et_update_ItemName);
        et_update_Quantity= view.findViewById(R.id.et_update_Quantity);
        et_update_Expired= view.findViewById(R.id.et_update_Expired);
        btn_update = view.findViewById(R.id.btn_update_user);
        btn_cancel = view.findViewById(R.id.btn_update_cancel);

        et_update_ItemName.setText(e1);
        et_update_Quantity.setText(e2);
        et_update_Expired.setText(e3);


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                e1 = et_update_ItemName.getText().toString();
                e2= et_update_Quantity.getText().toString();
                e3= et_update_Expired.getText().toString();
                Helperclass1 helperclass1=new Helperclass1(e1,e2,e3);
                reference.child(e1).setValue(helperclass1);
                user userData = new user();

                userData.setName(e1);
                userData.setQuantity(e2);
                userData.setExpired(e3);

                adapter.UpdateData(position,userData);
                Toast.makeText(MyFridgeList.this,"Item Updated..",Toast.LENGTH_SHORT).show();

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
}
















