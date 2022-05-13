package com.example.classleyapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapteretu  extends FirebaseRecyclerAdapter<modeletu,adapteretu.myviewholder>
{
 public adapteretu(@NonNull FirebaseRecyclerOptions<modeletu> options) {
  super(options);
 }

 @Override
 protected void onBindViewHolder(@NonNull myviewholder holder, int pos, @NonNull modeletu model) {
  holder.name.setText(model.getName());
  holder.code.setText(model.getCodeApogee());
  holder.email_institu.setText(model.getEmail_institutionnel());
  Glide.with(holder.img.getContext()).load(model.getSurl()).into(holder.img);
 // Edit
  holder.edit.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
            .setContentHolder(new ViewHolder(R.layout.dialoguecontent1))
            .setExpanded(true,1500)
            .create();

    View myview=dialogPlus.getHolderView(); //hna
    final EditText surl=myview.findViewById(R.id.uimgurl);
    final EditText name=myview.findViewById(R.id.uname);
    final EditText codeApogee=myview.findViewById(R.id.ucodeapogee);
    final EditText Email_institutionnel=myview.findViewById(R.id.uemail_institu);
    Button submit=myview.findViewById(R.id.usubmit);

    surl.setText(model.getSurl());
    name.setText(model.getName());
    codeApogee.setText(model.getCodeApogee());
    Email_institutionnel.setText(model.getEmail_institutionnel());
    //pour affichage de dialogue view
    dialogPlus.show();

    submit.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) { //hna
      Map<String,Object> map=new HashMap<>();
      map.put("surl",surl.getText().toString());
      map.put("name",name.getText().toString());
      map.put("Email_institutionnel",Email_institutionnel.getText().toString());
      map.put("codeApogee",codeApogee.getText().toString());

      FirebaseDatabase.getInstance().getReference().child("Students")
              .child(getRef(pos).getKey()).updateChildren(map)
              .addOnSuccessListener(new OnSuccessListener<Void>() {
               @Override
               public void onSuccess(Void aVoid) {
                dialogPlus.dismiss();
               }
              })
              .addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {
                dialogPlus.dismiss();
               }
              });
     }
    });


   }
  });


  holder.delete.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
    builder.setTitle("Delete Panel");
    builder.setMessage("you want to delete this panel...?");

    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
     @Override
     public void onClick(DialogInterface dialogInterface, int i) {
      FirebaseDatabase.getInstance().getReference().child("Students")
              .child(getRef(pos).getKey()).removeValue();
     }
    });

    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
     @Override
     public void onClick(DialogInterface dialogInterface, int i) {

     }
    });

    builder.show();
   }
  });


 }


 @NonNull
 @Override
 public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
  View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowetu,parent,false);
  return new myviewholder(view);
 }

 class myviewholder extends RecyclerView.ViewHolder
 {
  CircleImageView img;
  TextView name,code,email_institu;
  ImageView edit,delete;
  public myviewholder(@NonNull View itemView)
  {
   super(itemView);
   img=(CircleImageView)itemView.findViewById(R.id.img11);
   name=(TextView)itemView.findViewById(R.id.nametext1);
   code=(TextView)itemView.findViewById(R.id.codeapogeetext);
   email_institu=(TextView)itemView.findViewById(R.id.email_institutext);
   edit=(ImageView)itemView.findViewById(R.id.editicon);
   delete=(ImageView)itemView.findViewById(R.id.deleteicon);

  }

 }
}
