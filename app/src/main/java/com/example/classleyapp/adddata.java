package com.example.classleyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class adddata extends AppCompatActivity
{
    EditText name,course,email,purl;
    Button submit,back;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        name=(EditText)findViewById(R.id.add_name);
        email=(EditText)findViewById(R.id.add_email);
        course=(EditText)findViewById(R.id.add_course);
        purl=(EditText)findViewById(R.id.add_purl);

     //   back=(Button)findViewById(R.id.add_back);
        ic_back=(ImageView)findViewById(R.id.ic_back1) ;

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),gestion_Prof.class));
                finish();
            }
        });

        submit=(Button)findViewById(R.id.add_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("course",course.getText().toString());
        map.put("email",email.getText().toString());
        map.put("purl",purl.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("teachers").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name.setText("");
                        course.setText("");
                        email.setText("");
                        purl.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show();
                    }
                });

    }
}