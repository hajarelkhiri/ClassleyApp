package com.example.classleyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapteretu  extends FirebaseRecyclerAdapter<modeletu,adapteretu.myviewholder>
{
 public adapteretu(@NonNull FirebaseRecyclerOptions<modeletu> options) {
  super(options);
 }

 @Override
 protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull modeletu model) {
  holder.name.setText(model.getName());
  holder.code.setText(model.getCodeApogee());
  holder.email_institu.setText(model.getEmail_institutionnel());
  Glide.with(holder.img.getContext()).load(model.getSurl()).into(holder.img);

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

  }

 }
}
