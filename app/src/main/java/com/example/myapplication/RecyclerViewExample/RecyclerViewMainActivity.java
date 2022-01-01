package com.example.myapplication.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    ArrayList<Mobiles> mobilesList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        //Binding RecyclerView object to recycler View in design
        myRecyclerView = findViewById(R.id.myrecyclerview);
        mobilesList = new ArrayList<>();
        myAdapter = new MyAdapter(mobilesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
        myRecyclerView.setAdapter(myAdapter);
        AddMobiles();
    }

    public void AddMobiles(){
        Mobiles mobiles = new Mobiles("Pixel 6 Pro", "Google", "140,000");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("Iphone 13", "Apple", "240,000");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("A54", "Vivo", "27,000");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("S22", "Samsung", "210,000");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("F19", "Oppo", "80,000");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("A54", "Vivo", "27,000");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("S22", "Samsung", "210,000");
        mobilesList.add(mobiles);
        myAdapter.notifyDataSetChanged();
    }
}