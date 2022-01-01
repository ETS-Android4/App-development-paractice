package com.example.myapplication.FirebaseExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerViewExample.MyAdapter;

import java.util.ArrayList;

public class MyFirebasrAdapter extends RecyclerView.Adapter<MyFirebasrAdapter.ViewHolder> {

    ArrayList<Fast_Student> fast_studentArrayList;
    Context context;

    public MyFirebasrAdapter(ArrayList<Fast_Student> fast_studentArrayList, Context context) {
        this.fast_studentArrayList = fast_studentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyFirebasrAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.mystudentlistview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyFirebasrAdapter.ViewHolder holder, int position) {
        holder.textView.setText(fast_studentArrayList.get(position).getName());
        Glide.with(context).load(fast_studentArrayList.get(position).getURL()).
                into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return fast_studentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder (@NonNull View v){
            super(v);
            imageView = v.findViewById(R.id.firebaseimageview);
            textView = v.findViewById(R.id.firebasetextview);
        }
    }
}
