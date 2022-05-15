package com.example.classleyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.classleyapp.databinding.ActivityMainBinding;

public class Home extends AppCompatActivity {
    CardView gestionprof ,gestionEtu ,gestionEmploi;
    ActivityMainBinding binding;
    ImageView btn_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        gestionprof=(CardView) findViewById(R.id.gestionprof);
        gestionEtu=(CardView) findViewById(R.id.gestionetu);
        gestionEmploi=(CardView) findViewById(R.id.emploi);
        btn_log=(ImageView)findViewById(R.id.btn_logout);

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

   btn_log.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           PopupMenu popupMenu = new PopupMenu(Home.this, btn_log);
           popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
           popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
               @Override
               public boolean onMenuItemClick(MenuItem menuItem) {
                   // Toast message on menu item clicked
                   Toast.makeText(Home.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                   return true;
               }
           });
           // Showing the popup menu
           popupMenu.show();

       }
   });


    }
}