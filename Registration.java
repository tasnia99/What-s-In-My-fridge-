package com.example.designpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    TextView btn;
    TextInputLayout signupName,signupEmail,signupPassword,signupUsername;
    Button btnRegister;
   FirebaseDatabase rootNode;
   DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);


        btn = findViewById(R.id.alreadyHaveAccount);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupUsername = findViewById(R.id.signup_username);

        btnRegister = findViewById(R.id.btnRegistration);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               rootNode =FirebaseDatabase.getInstance();
               reference= rootNode.getReference("Users");
               String name=signupName.getEditText().getText().toString();
                String email=signupEmail.getEditText().getText().toString();
                String password=signupPassword.getEditText().getText().toString();
                String username=signupUsername.getEditText().getText().toString();
               HelperClass helperClass=new HelperClass(name,email,password,username);
              reference.child(name).setValue(helperClass);
           Toast.makeText(Registration.this,"Registration successfull",Toast.LENGTH_SHORT).show();
           Intent intent=new Intent(Registration.this,Login.class);
           startActivity(intent);

            }
        });



    btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this,Login.class));
            }
        });
    }







}
