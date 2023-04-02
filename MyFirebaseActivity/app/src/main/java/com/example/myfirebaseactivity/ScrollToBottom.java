package com.example.myfirebaseactivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ScrollToBottom extends RecyclerView.AdapterDataObserver {
    LinearLayoutManager manager;
    NameAdapter adapter;
    RecyclerView view;

    public ScrollToBottom(RecyclerView vi, NameAdapter ad, LinearLayoutManager man){
        manager = man;
        adapter = ad;
        view = vi;
    }

    @Override
    public void onItemRangeInserted(int pS, int iC){
        super.onItemRangeInserted(pS,iC);
        int count = adapter.getItemCount();

        int lastVS = manager.findLastCompletelyVisibleItemPosition();

        boolean loading = lastVS==-1;
        boolean atBottom = ((pS>=count-1)&&(lastVS==pS-1));
        if(loading||atBottom){
            view.scrollToPosition(pS);
        }
    }
}
