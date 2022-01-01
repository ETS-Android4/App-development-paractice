package com.example.myapplication.ListViewExamples;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListAdapter extends BaseAdapter {

    public ArrayList<HashMap<String,String>> list;
    Activity activity;
    public static final String First_Column = "First";
    public static final String Second_Column = "Second";
    public static final String Third_Column = "Third";
    public static final String Fourth_Column = "Fourth";

    public MyListAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = activity.getLayoutInflater();
        if (convertView == null){
            convertView = inflater.inflate(R.layout.multicolumnrow,null);
            viewHolder.textfirst = convertView.findViewById(R.id.txt_first);
            viewHolder.textsecond = convertView.findViewById(R.id.txt_second);
            viewHolder.textthird = convertView.findViewById(R.id.txt_third);
            viewHolder.textfourth = convertView.findViewById(R.id.txt_fourth);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, String> map = list.get(position);
        viewHolder.textfirst.setText(map.get(First_Column));
        viewHolder.textsecond.setText(map.get(Second_Column));
        viewHolder.textthird.setText(map.get(Third_Column));
        viewHolder.textfourth.setText(map.get(Fourth_Column));

        return convertView;
    }

    public class ViewHolder{
        TextView textfirst, textsecond, textthird, textfourth;
    }
}
