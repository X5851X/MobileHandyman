package com.example.mobileprogproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class order extends AppCompatActivity {

    ListView listView;
    DatabaseHelper databaseHelper;
    ArrayList<String> listitem;
    ArrayAdapter<String> adapter; // Ubah tipe ArrayAdapter ke ArrayAdapter<String>
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        listView = (ListView) findViewById(R.id.listview_myorder);

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
                        startActivity(new Intent(getApplicationContext(),product.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.chart:
                        return true;
                }
                return false;
                //botom navbar
            }
        });
        databaseHelper = new DatabaseHelper(this);
        listitem = new ArrayList<>();

        ListOrder();

        button = (Button) findViewById(R.id.paynowbtn_myorder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backhome();
            }
        });
    }

    private void backhome() {
        Toast.makeText(order.this, "Your Order Complete, Thank You!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, home.class);
        startActivity(intent);

        // Mengosongkan listitem dan memperbarui ListView
        listitem.clear();
        adapter.notifyDataSetChanged();

        // Menghapus semua data dari tabel
        databaseHelper.deleteAllData();
    }


    private void ListOrder() {
        Cursor cursor = databaseHelper.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_LONG).show();
            //check data kosong atau tidak
        }else{
            while (cursor.moveToNext()){
                listitem.add(cursor.getString(0));
                //check apakah ada data dari array index ke 0 || diambil dari function cursor pada databasehelper
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
            listView.setAdapter(adapter);
        }
    }
}
