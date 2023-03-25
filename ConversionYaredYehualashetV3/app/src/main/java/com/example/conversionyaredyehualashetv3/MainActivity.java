package com.example.conversionyaredyehualashetv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit = (EditText) findViewById(R.id.editTextEuro);
        edit.setText("0",TextView.BufferType.EDITABLE);
        findViewById(R.id.convertButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView dollar;
                TextView euro;
                euro = (TextView) findViewById(R.id.editTextEuro);
                dollar = (TextView) findViewById(R.id.returnDollars);
                final DecimalFormat df = new DecimalFormat("0.00");
                Double val = Double.valueOf(euro.getText().toString().trim());
                if(!val.isNaN()){
                    dollar.setText(df.format(convert(val)));
                }
                else{
                    Toast.makeText(dollar.getContext(),"Not a Number Thrown",Toast.LENGTH_SHORT).show();
                }
            }
        }
        );
    }
    double convert(Double amm){
        return amm*1.3;
    }
}