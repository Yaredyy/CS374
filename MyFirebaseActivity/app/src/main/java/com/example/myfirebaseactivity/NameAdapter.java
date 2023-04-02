package com.example.myfirebaseactivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;


public class NameAdapter extends FirebaseRecyclerAdapter<NameBlock,NameAdapter.nameHolder> {
    DatabaseReference ref;
    public NameAdapter(FirebaseRecyclerOptions<NameBlock> op, DatabaseReference re){
        super(op);
        ref = re;
    }
    @Override
    public nameHolder onCreateViewHolder(ViewGroup parent, int type){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.name_bar, parent, false);
        return new nameHolder(view);
    }
    @Override
    protected void onBindViewHolder(@NonNull nameHolder holder, int position, NameBlock model) {
        holder.fn.setText(model.firstName);
        holder.ln.setText(model.lastName);
        holder.db.setOnClickListener(v -> {
            Query query = ref.orderByChild("firstName").equalTo(model.firstName);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    long c = dataSnapshot.getChildrenCount();
                    Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                    for(int i = 0; i < c-1; i++){
                        it.next();
                    }
                    it.next().getRef().removeValue();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("NAMEADAPTER", "onCancelled", databaseError.toException());
                }
            });


        });
    }



    @Override
    public int getItemViewType(int ps){
        return 0;
    }


    class nameHolder extends RecyclerView.ViewHolder {

        TextView fn;
        TextView ln;
        ImageView db;

        public nameHolder(View view){
            super(view);
            fn = view.findViewById(R.id.FirstName);
            ln = view.findViewById(R.id.LastName);
            db = view.findViewById(R.id.DeleteButton);
        }

    }

}
