package com.example.myapplication.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewMainActivity extends AppCompatActivity {

    public ArrayList <HashMap<String,String>> list;
    public static final String First_Column = "First";
    public static final String Second_Column = "Second";
    public static final String Third_Column = "Third";
    public static final String Fourth_Column = "Fourth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view_main);
        ListView lst = findViewById(R.id.lstmulticolumn);
        LoadList();
        MyListAdapter obj = new MyListAdapter(this, list);
        lst.setAdapter(obj);

    }

    public void LoadList(){
        list = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> hashmap1 = new HashMap<String, String>();
        hashmap1.put(First_Column,"Ali");
        hashmap1.put (Second_Column, "Kashif");
        hashmap1.put(Third_Column,"Sheikh Sb");
        hashmap1.put(Fourth_Column,"Awais");
        list.add(hashmap1);

        HashMap<String, String> hashmap2 = new HashMap<String, String>();
        hashmap2.put(First_Column,"Ayesha");
        hashmap2.put (Second_Column, "Rizwan");
        hashmap2.put(Third_Column,"Usama");
        hashmap2.put(Fourth_Column,"Shafique");
        list.add(hashmap2);

        HashMap<String, String> hashmap3 = new HashMap<String, String>();
        hashmap3.put(First_Column,"Saad");
        hashmap3.put (Second_Column, "Mustafa");
        hashmap3.put(Third_Column,"Abdullah");
        hashmap3.put(Fourth_Column,"Tariq");
        list.add(hashmap3);

        HashMap<String, String> hashmap4 = new HashMap<String, String>();
        hashmap4.put(First_Column,"Ali Ahmed");
        hashmap4.put (Second_Column, "Kashif Ali");
        hashmap4.put(Third_Column,"Ahmad Ibrahim");
        hashmap4.put(Fourth_Column,"Furqn Abaid");
        list.add(hashmap4);

    }


}