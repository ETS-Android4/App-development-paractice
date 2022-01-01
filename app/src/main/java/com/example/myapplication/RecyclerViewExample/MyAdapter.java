package com.example.myapplication.RecyclerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList <Mobiles> mobilesList;
    private String[] myData;

    public MyAdapter(ArrayList<Mobiles> mobilesList) {
        this.mobilesList = mobilesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobilerow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mobiles mobiles = mobilesList.get(position);
        holder.MobileName.setText(mobiles.getName());
        holder.MobileCompany.setText(mobiles.getCompany());
        holder.MobilePrice.setText(mobiles.getPrice());

    }

    @Override
    public int getItemCount() {
        return mobilesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView MobileName, MobileCompany, MobilePrice;
        public ViewHolder(@NonNull View View) {
            super(View);
            MobileName = View.findViewById(R.id.txtmobilename);
            MobileCompany = View.findViewById(R.id.txtmobilecompany);
            MobilePrice = View.findViewById(R.id.txtmobileprice);

        }
    }

}
