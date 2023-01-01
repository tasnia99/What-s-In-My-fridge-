package com.example.designpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Recipe_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        getSupportActionBar().hide();
    }
}