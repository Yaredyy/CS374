package com.example.asyncimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTaskImgDownloader(this).execute("https://picsum.photos/1000/1000");

        findViewById(R.id.img_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTaskImgDownloader(MainActivity.this).execute("https://picsum.photos/1000/1000");
            }
        });
    }
}