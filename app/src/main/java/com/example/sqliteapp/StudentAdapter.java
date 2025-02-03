package com.example.sqliteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {



    ArrayList<Student> list;
    OnStudentItemClickListener itemClickListener;

    public StudentAdapter(ArrayList<Student> list,OnStudentItemClickListener itemClickListener) {
        this.list = list;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {

        holder.tvId.setText(""+list.get(position).getId());
        holder.tvName.setText(""+list.get(position).getName());
        holder.tvCity.setText(""+list.get(position).getCity());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(list.get(position),position,"delete");
            }
        });

        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemClickListener.onItemClick(list.get(position),position,"update");
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvName;
        TextView tvCity;
        ImageView ivDelete;
        ImageView ivEdit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId);
            tvName=itemView.findViewById(R.id.tvName);
            tvCity=itemView.findViewById(R.id.tvCity);
            ivDelete=itemView.findViewById(R.id.ivDelete);
            ivEdit=itemView.findViewById(R.id.ivEdit);
        }
    }
}
