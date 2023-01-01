package com.example.designpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
ImageButton Fridge;
ImageButton Recipes;
ImageButton Ingredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();

       Fridge=findViewById(R.id.imageButton5);
       Fridge.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentLoadAcitvity=new Intent(HomePage.this,MyFridgeList.class);
               startActivity(intentLoadAcitvity);
           }


       });
        Recipes=findViewById(R.id.imageButton);
        Recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadAcitvity=new Intent(HomePage.this,GetRecipes.class);
                startActivity(intentLoadAcitvity);
            }


        });
        Ingredients= findViewById(R.id.imageButton6);
        Ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadAcitvity=new Intent(HomePage.this,GetIngredients.class);
                startActivity(intentLoadAcitvity);
            }


        });



    }}




