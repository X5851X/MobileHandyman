package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button log = (Button) findViewById(R.id.loginawal);
        Button reg = (Button) findViewById(R.id.registerawal);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage1();
            }
        });

    }
    public void nextpage(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void nextpage1(){
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }
}