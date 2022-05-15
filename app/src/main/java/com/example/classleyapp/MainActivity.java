package com.example.classleyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText Editemail,Editpassword;
    Button button;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Editemail=findViewById(R.id.Editemail);
        Editpassword=findViewById(R.id.Editpassword);
        button=findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
 button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         String mail=Editemail.getText().toString();
         String pass=Editpassword.getText().toString();
         if(mail.isEmpty() || pass.isEmpty())
         {
             Toast.makeText(MainActivity.this, " This case is Required", Toast.LENGTH_SHORT).show();
             return;
         }
        else  if(pass.length()<6)
         {
             Toast.makeText(MainActivity.this, " YOU should write more than 6 character", Toast.LENGTH_SHORT).show();
             return;
         }
         else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
         {
             Editemail.setError("Please Provide a valid email !");
             Editemail.requestFocus();
             return;
         }
         else if(mail.equals("sokainanadi@gmail.com")&& pass.equals("sokainanadi"))
         {
             startActivity(new Intent(getApplicationContext(),UserDataprf.class));
         }
         else if(mail.equals("ayaassad@gmail.com")&& pass.equals("ayaaya")){
             startActivity(new Intent(getApplicationContext(),UserDataetu.class));
         }
         else{
             mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     //we check if the login is successful or not
                     if (task.isSuccessful())
                     {
                         Toast.makeText(MainActivity.this,"login Successful",Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(),Home.class));
                     }
                     else
                     {
                         Toast.makeText(MainActivity.this,"login Field",Toast.LENGTH_SHORT).show();



                     }

                 }
             });
         }
     }
 });

    }
}