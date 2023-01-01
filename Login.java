package com.example.designpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {

 TextInputLayout loginUsername,loginPassword;
 Button btnlgn;
 TextView signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        signupbtn = findViewById(R.id.textViewSignUp);
        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        btnlgn = findViewById(R.id.btnlogin);
        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUsername() | !validatePassword()) {

                } else {
                    checkusers();
                }


            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });

    }

         public Boolean validateUsername() {
             String val = loginUsername.getEditText().getText().toString();
             if (val.isEmpty()) {
                 loginUsername.setError("Username can not be empty");
                 return false;

             } else {
                 loginUsername.setError(null);
                 return true;
             }
         }
    public Boolean validatePassword() {
        String val = loginPassword.getEditText().getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password can not be empty");
            return false;

        } else {
            loginPassword.setError(null);
            return true;
        }
    }
    public void checkusers(){
        String userusername=loginUsername.getEditText().getText().toString().trim();
        String pass=loginPassword.getEditText().getText().toString().trim();

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Users");
        Query checkusersDatabase=reference.orderByChild("username").equalTo(userusername);

        checkusersDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    loginUsername.setError(null);
                String passwordfromDB = snapshot.child(userusername).child("password").getValue(String.class);


                if (!Objects.equals(passwordfromDB,pass)) {
                    loginUsername.setError(null);
                    Intent intent=new Intent(Login.this,HomePage.class);
                    startActivity(intent);
                }

                else {
                    loginPassword.setError("Invalid password");
                    loginPassword.requestFocus();
                }

                }else{
                    loginUsername.setError("Invalid username");
                    loginUsername.requestFocus();
               }

                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        }}






