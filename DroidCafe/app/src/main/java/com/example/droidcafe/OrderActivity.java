package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        findViewById(R.id.cart_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mA = new Intent(OrderActivity.this,MainActivity.class);
                startActivity(mA);
            }
        });
    }
}