
package com.example.project401_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Complain;


import java.util.ArrayList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {
    List<Complain> allTasks = new ArrayList<Complain>();

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public TasksAdapter(List<Complain> allTasks) {
        this.allTasks = allTasks;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class TasksViewHolder extends RecyclerView.ViewHolder {

        private String title;
        public Button mTasks;

        public TasksViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            mTasks = (Button) itemView.findViewById(R.id.titleInFragment);

            itemView.findViewById(R.id.titleInFragment).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }

            });
        }

    }


    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_blank, parent, false);
        return new TasksViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        Complain tasks = allTasks.get(position);
        holder.mTasks.setText(tasks.getUsername());


    }

    @Override
    public int getItemCount() {
        return allTasks.size();
    }

    public  void setAllTasks(List<Complain> tasks) {
        this.allTasks = tasks;
//        notifyDataSetChanged();
    }
}