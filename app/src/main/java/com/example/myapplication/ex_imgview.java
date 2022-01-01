package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ex_imgview extends AppCompatActivity {

    ImageView imageview;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_imgview);
        imageview = findViewById(R.id.im1);
        textview = findViewById(R.id.txtvalue);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Key");
        textview.setText(name);
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    public void SetImage(View view) {
        imageview.setImageResource(R.drawable.leaves);
    }
}