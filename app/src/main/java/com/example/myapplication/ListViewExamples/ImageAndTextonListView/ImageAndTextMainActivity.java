package com.example.myapplication.ListViewExamples.ImageAndTextonListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ImageAndTextMainActivity extends AppCompatActivity {

    ListView listview;
    String [] Name = {"Rizwan", "Umer Aleem","Mufti Tariq Masood","Junaid"};
    String [] Text = {"Prince Rizi is a good boy","Kisi ko na btaii","Jehlum aa gia hun","Ma naif batun ga"};
    Integer [] image = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image_and_text_main);
//        listview = findViewById(R.id.lstimageandtext);
//        MyAdapterList myAdapterList = new MyAdapterList(this,Name,Text,image);
//        listview.setAdapter(myAdapterList);
//        listview.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0 ){
//                    Toast.makeText(ImageAndTextMainActivity.this,"Item 1",Toast.LENGTH_SHORT).show();
//                }
//                if (position == 1 ){
//                    Toast.makeText(ImageAndTextMainActivity.this,"Item 2",Toast.LENGTH_SHORT).show();
//                }
//                if (position == 2 ){
//                    Toast.makeText(ImageAndTextMainActivity.this,"Item 3",Toast.LENGTH_SHORT).show();
//                }
//                if (position == 3 ){
//                    Toast.makeText(ImageAndTextMainActivity.this,"Item 4",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}