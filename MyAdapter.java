package com.example.designpage;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bhaumik on 8/29/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

    List<user> list=new ArrayList<>();

    ItemClickListener itemClickListener;


    public MyAdapter(List<user> list) {
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new MyHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        final user userData = list.get(position);

        holder.item1.setText(userData.getName());
        holder.quantity1.setText(userData.getQuantity());
        holder.expired1.setText(userData.getExpired());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.OnItemClick(position,userData);
            }
        });

        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{


        TextView item1,quantity1,expired1,tv_delete;

        public MyHolder(View itemView) {
            super(itemView);

            item1 = itemView.findViewById(R.id.ItemName);
            quantity1 = itemView.findViewById(R.id.Quantity);
            expired1 = itemView.findViewById(R.id.Expired);
            tv_delete=itemView.findViewById(R.id.tv_delete_item);
        }
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public void UpdateData(int position,user userData){

        list.remove(position);
        list.add(userData);
        notifyItemChanged(position);
        notifyDataSetChanged();
    }
}

