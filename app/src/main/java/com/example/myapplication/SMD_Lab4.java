package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SMD_Lab4 extends AppCompatActivity {

    ListView listview;
    String[] Mobilelist = {"Note 10","Oppo","Galaxy S9","Nokia 3310","Iphone 12","A3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smd_lab4);
        listview = findViewById(R.id.lstone);
        ArrayAdapter adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Mobilelist);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long Id) {
                Toast.makeText(SMD_Lab4.this,
                        "Position: "+position+" ID: "+Id,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}