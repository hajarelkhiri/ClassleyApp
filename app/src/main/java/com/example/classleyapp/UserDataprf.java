package com.example.classleyapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class UserDataprf extends AppCompatActivity {
    RecyclerView recviewetu;
    adapteretu adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dataprf);
        recviewetu=(RecyclerView)findViewById(R.id.recview1);
        recviewetu.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<modeletu> options =
                new FirebaseRecyclerOptions.Builder<modeletu>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Students"), modeletu.class)
                        .build();
        adapter = new adapteretu(options);
        recviewetu.setAdapter(adapter);

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