package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.SMS_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SMSIntent = new Intent(Intent.ACTION_MAIN);
                SMSIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                try{
                    startActivity(SMSIntent);
                } catch(ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, R.string.SMS_Text + " gave activity not found error", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.Phone_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(Intent.ACTION_MAIN);
                phoneIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);

                try{
                    startActivity(phoneIntent);
                } catch(ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, R.string.Phone_Text + " gave activity not found error", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.Web_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(Intent.ACTION_MAIN);
                webIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, R.string.Web_Text + " gave activity not found error", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.Map_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_MAIN);
                mapIntent.addCategory(Intent.CATEGORY_APP_MAPS);
                try {
                    startActivity(mapIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, R.string.Web_Text + " gave activity not found error", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.Share_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                String chooserText = getResources().getString(R.string.Chooser_Text);
                Intent shareChooser = Intent.createChooser(shareIntent,chooserText);
                try {
                    startActivity(shareChooser);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, R.string.Web_Text + " gave activity not found error", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}