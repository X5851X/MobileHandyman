package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {

    ImageView imageView;
    TextView textView1, textView2;
    Button order, orderbtn;
    EditText editText;
    DatabaseHelper databaseHelper;
    boolean isPaid = false; // Variabel penanda untuk status pembayaran

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        databaseHelper = new DatabaseHelper(this);
        imageView = (ImageView) findViewById(R.id.image_detail);
        textView1 = (TextView) findViewById(R.id.title_detail);
        textView2 = (TextView) findViewById(R.id.price_detail);
        orderbtn = (Button) findViewById(R.id.orderbtn_detail);

        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openorder();
            }
        });

        Bundle bundle = getIntent().getExtras();
        final Integer image = bundle.getInt("image");
        final String name = bundle.getString("name");
        Integer price = bundle.getInt("price");

        imageView.setImageResource(image);
        textView1.setText(name);
        textView2.setText("Rp." + price);

        order = (Button) findViewById(R.id.cart);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = textView1.getText().toString();
                String priceTxt = textView2.getText().toString();

                Boolean checkdata = databaseHelper.insertdata(nameTxt, priceTxt);
                if (checkdata) {
                    Toast.makeText(Detail.this, "Data Stored", Toast.LENGTH_LONG).show();
                    isPaid = true; // Set status pembayaran menjadi true
                    Intent intent = new Intent(Detail.this, product.class);
                    startActivity(intent);
                } else {
                    Boolean updatedata = databaseHelper.updatedata(nameTxt, priceTxt);
                    if (updatedata) {
                        Toast.makeText(Detail.this, "Data updated", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Button ordermore = (Button) findViewById(R.id.order_More2);
        ordermore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordermore();
            }
        });
    }

    private void openorder() {
        Intent intent = new Intent(this, order.class);
        intent.putExtra("isPaid", isPaid); // Mengirim status pembayaran ke halaman order
        startActivity(intent);
    }

    private void ordermore() {
        Intent intent = new Intent(this, product.class);
        startActivity(intent);
    }
}
