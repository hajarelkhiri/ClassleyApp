package com.example.classleyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.classleyapp.databinding.ActivityMainBinding;

public class Home extends AppCompatActivity {
    CardView gestionprof ,gestionEtu ,gestionEmploi;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);




        gestionprof=(CardView) findViewById(R.id.gestionprof);
        gestionEtu=(CardView) findViewById(R.id.gestionetu);
        gestionEmploi=(CardView) findViewById(R.id.emploi);

        gestionprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),gestion_Prof.class));
            }
        });
        gestionEtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),gestion_etu.class));
            }
        });
        gestionEmploi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),gestionEmploi.class));
            }
        });


    }
}