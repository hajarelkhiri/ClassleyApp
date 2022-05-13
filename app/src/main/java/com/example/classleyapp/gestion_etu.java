package com.example.classleyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class gestion_etu extends AppCompatActivity {
    RecyclerView recviewetu;
    adapteretu adapter;
    FloatingActionButton fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_etu2);
        recviewetu=(RecyclerView)findViewById(R.id.recviewetu);
        recviewetu.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<modeletu> options =
                new FirebaseRecyclerOptions.Builder<modeletu>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Students"), modeletu.class)
                        .build();
        adapter = new adapteretu(options);
        recviewetu.setAdapter(adapter);


        fb=(FloatingActionButton)findViewById(R.id.fadd);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),adddataetu.class));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<modeletu> options =
                new FirebaseRecyclerOptions.Builder<modeletu>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Students").orderByChild("codeApogee").startAt(s).endAt(s+"\uf8ff"), modeletu.class)
                        .build();

        adapter=new adapteretu(options);
        adapter.startListening();
        recviewetu.setAdapter(adapter);

    }

}