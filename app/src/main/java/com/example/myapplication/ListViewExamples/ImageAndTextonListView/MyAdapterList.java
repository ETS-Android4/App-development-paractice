package com.example.myapplication.ListViewExamples.ImageAndTextonListView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class MyAdapterList extends ArrayAdapter<String> {

    public Activity activity;
    public String[] Name;
    public String[] Text;
    public Integer[] image;

    public MyAdapterList(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public MyAdapterList(Activity activity, String[] Name, String[] Text, Integer[] image){
        super(activity, R.layout.mylistlayout,Name);
        this.activity = activity;
        this.Name = Name;
        this.Text = Text;
        this.image = image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View viewHolder = inflater.inflate(R.layout.mylistlayout,null);
        TextView textview = viewHolder.findViewById(R.id.txtimg1);
        TextView textview1 = viewHolder.findViewById(R.id.txtimg2);
        ImageView imageview = viewHolder.findViewById(R.id.imagtxt1);
        textview.setText(Name[position]);
        textview1.setText(Text[position]);
        imageview.setImageResource(image[position]);
        return viewHolder;
    }
}
