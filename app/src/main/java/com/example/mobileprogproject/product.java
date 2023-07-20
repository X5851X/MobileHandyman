package com.example.mobileprogproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class product extends AppCompatActivity {

    RecyclerView recyclerView;
    Button orderbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        orderbtn = (Button) findViewById(R.id.orderbtn);
        recyclerView  = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        //fixed ukuran gambar
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView navbar = findViewById(R.id.bottom_navigation);
        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.product:
                        return true;
                    case R.id.chart:
                        startActivity(new Intent(getApplicationContext(),order.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
                //navbar
            }
        });
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openorder();
            }
        });


        model[] list = new model[]{
                new model("Kuli Bangunan",R.drawable.kuli1,100000),
                new model("Kuli Cat",R.drawable.kuli2,100000),
                new model("Kuli Kayu",R.drawable.kuli3,80000),
                new model("Kuli Bangunan",R.drawable.kuli4, 50000),
                //input data kedalam recyleview
        };
        MainAdapter Adapter = new MainAdapter(list, product.this);
        recyclerView.setAdapter(Adapter);
        //adapter jembatan antara view dengan data
    }
    private void openorder() {
        Intent intent = new Intent(this,order.class);
        startActivity(intent);
    }
}