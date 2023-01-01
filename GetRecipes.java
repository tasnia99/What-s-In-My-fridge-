package com.example.designpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class GetRecipes extends AppCompatActivity {
    private GridView gridview;
    int[] pic = {R.drawable.basantipolao, R.drawable.chikenbiriyani, R.drawable.beefcurry,
            R.drawable.dimvhuna, R.drawable.doibegun, R.drawable.fishtikkamasala,
            R.drawable.sorisaliish, R.drawable.niramishshobji, R.drawable.murgirezala, R.drawable.dal};

    String[] foodNames;
    List<ItemsModel> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_recipes);

        foodNames = getResources().getStringArray(R.array.food);
        gridview = (GridView) findViewById(R.id.gridViewid);
        for (int i = 0; i < foodNames.length; i++) {
            ItemsModel itemsModel = new ItemsModel(foodNames[i], pic[i]);
            itemsList.add(itemsModel);
        }


        CustomAdapter adapter = new CustomAdapter(this, foodNames, pic);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(GetRecipes.this, Recipe_Details.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(GetRecipes.this, Second.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(GetRecipes.this, Third.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(GetRecipes.this, Fourth.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(GetRecipes.this, Fifth.class);
                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(GetRecipes.this, Sixth.class);
                    startActivity(intent);
                }

            }
        });
    }

            public boolean onCreateOptionsMenu(Menu menu) {

                getMenuInflater().inflate(R.menu.menu, menu);

                MenuItem menuItem = menu.findItem(R.id.action_search);
                SearchView searchView = (SearchView) menuItem.getActionView();

                searchView.setQueryHint("Type Here For Reciepes");
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {


                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {

                      gridview.getTextFilter();

                      return true;
                    }
                });
            return true;
            }


    }





