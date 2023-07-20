package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private Button log;
    private TextView sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log = (Button) findViewById(R.id.loginbutt);
        sign = (TextView) findViewById(R.id.sign);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage();
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage1();
            }
        });
    }
    public void nextpage(){
        Intent intent = new Intent(this,home.class);
        startActivity(intent);
    }
    public void nextpage1(){
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }
}