package com.example.classleyapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDataetu1 extends AppCompatActivity {
    TextView fullname,code,email,phone;
    ImageView image;
    FirebaseDatabase database;
    FirebaseAuth auth;
    DatabaseReference mDatabase;
    ImageView ic_back;
    LinearLayout l2;
    TextView l4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child("Students");

        setContentView(R.layout.activity_user_dataetu1);

        fullname=(TextView)findViewById(R.id.Fullname);
        code=(TextView) findViewById(R.id.occupation_textview);
        email=(TextView) findViewById(R.id.email_textview);
        image=(ImageView) findViewById(R.id.purl);
        ic_back=(ImageView)findViewById(R.id.ic_back1) ;
        l2=(LinearLayout)findViewById(R.id.l2);
        l4=(TextView) findViewById(R.id.phone_textview);
        phone=(TextView)findViewById(R.id.phone_textview);
        userRef.addValueEventListener(new ValueEventListener() {
            String name1, email1, code1;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {

                    name1 = keyId.child("name").getValue(String.class);
                    code1 = keyId.child("codeApogee").getValue(String.class);
                    email1 = keyId.child("Email_institutionnel").getValue(String.class);


                    break;

                }
                fullname.setText(name1);
                email.setText(email1);
                code.setText(code1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //   Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),gestion_etu.class));
                finish();
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GmailActivity.class));
                finish();
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone1 =l4.getText().toString();
                Intent intent= new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(phone1));
                startActivity(intent);
            }
        });
    }
}