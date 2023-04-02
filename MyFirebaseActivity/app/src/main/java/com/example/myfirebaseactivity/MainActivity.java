package com.example.myfirebaseactivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    NameAdapter adapter;
    LinearLayoutManager manager;
    FirebaseRecyclerOptions<NameBlock> options;
    DatabaseReference root;
    DatabaseReference eRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        RecyclerView rec = findViewById(R.id.NameRecycle);
        TextView fN = findViewById(R.id.firstName);
        TextView lN = findViewById(R.id.lastName);
        Button btn = findViewById(R.id.buttonAdd);


        db = FirebaseDatabase.getInstance();
        root = db.getReference();
        eRef = root.child("employees");

        options = new FirebaseRecyclerOptions.Builder<NameBlock>().setQuery(eRef,NameBlock.class).build();
        adapter = new NameAdapter(options,eRef);
        manager = new LinearLayoutManager(this);
        manager.setStackFromEnd(true);
        rec.setLayoutManager(manager);
        rec.setAdapter(adapter);
        adapter.registerAdapterDataObserver(new ScrollToBottom(rec,adapter,manager));


        fN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                btn.setEnabled(!fN.getText().toString().trim().equals("") && !lN.getText().toString().trim().equals(""));
            }
        });
        lN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                btn.setEnabled(!fN.getText().toString().trim().equals("") && !lN.getText().toString().trim().equals(""));
            }
        });



        btn.setOnClickListener(v -> {
            if(fN.getText().toString().trim()!=""&&lN.getText().toString().trim()!="") {
                NameBlock val = new NameBlock(fN.getText().toString().trim(), lN.getText().toString().trim());
                eRef.push().setValue(val);
                fN.setText("");
                lN.setText("");
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}