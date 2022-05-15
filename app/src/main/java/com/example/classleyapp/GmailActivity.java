package com.example.classleyapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classleyapp.databinding.ActivityGmailBinding;

public class GmailActivity extends AppCompatActivity {
EditText addresse,subject,message;
Button btn;
ActivityGmailBinding binding;
    ImageView ic_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addresse=(EditText) findViewById(R.id.addrese);
        subject=(EditText) findViewById(R.id.subject);
        message=(EditText) findViewById(R.id.Message1);
        btn= (Button) findViewById(R.id.button1);
        ic_back=(ImageView)findViewById(R.id.ic_back2) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String addresse=binding.addrese.getText().toString();
                String subject=binding.subject.getText().toString();
                String message=binding.Message1.getText().toString();


                String [] addresses =addresse.split(",");
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,message);




                if(intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(intent);
                }else{
                    Toast.makeText(GmailActivity.this, "No App is Installes", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),UserData.class));
                finish();
            }
        });

    }
}