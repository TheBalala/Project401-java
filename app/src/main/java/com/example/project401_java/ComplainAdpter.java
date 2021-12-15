package com.example.project401_java;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Complain;

import java.util.ArrayList;
import java.util.List;

public class ComplainAdpter extends RecyclerView.Adapter<ComplainAdpter.ComplainViewHolder>{

    List<Complain> allComplain = new ArrayList<>();

    public ComplainAdpter(List<Complain> allTask) {
        this.allComplain = allTask;
    }


    @NonNull
    @Override
    public ComplainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_complain2,parent,false);
        ComplainViewHolder complainViewHolder =new ComplainViewHolder(view);
        return complainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ComplainViewHolder holder, int position) {
        holder.complain = allComplain.get(position);
        TextView desc = holder.itemView.findViewById(R.id.ComplainTitle);
        TextView state = holder.itemView.findViewById(R.id.ComplainState);

        desc.setText(holder.complain.getDescription());
        state.setText(holder.complain.getState());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("adpterrrrrrrrrrrrrrrrrrr");
                Intent intent= new Intent(view.getContext(),ProblemDetails.class);
                intent.putExtra("des",holder.complain.getDescription());
                intent.putExtra("file",holder.complain.getFileUrl());
                intent.putExtra("state",holder.complain.getState());
                intent.putExtra("username",holder.complain.getUsername());
                intent.putExtra("categoryName",holder.complain.getCategoryName());
                intent.putExtra("cityName",holder.complain.getCityName());



                intent.putExtra("lat",holder.complain.getLat());
                intent.putExtra("lon",holder.complain.getLon());
                intent.putExtra("idComp",holder.complain.getId());




                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return allComplain.size();
    }

    public static class ComplainViewHolder extends RecyclerView.ViewHolder{

        public Complain complain;
        public View itemView;
        public ConstraintLayout constraintLayout;

        public ComplainViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;

            constraintLayout = itemView.findViewById(R.id.fragment);
        }
    }

}