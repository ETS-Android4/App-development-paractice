package com.example.myapplication.IntentExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;

public class SecodActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secod);
        Intent intent;
        intent = getIntent();
        int value1 = intent.getIntExtra("V1",0);
        int value2 = intent.getIntExtra("V2",0);
        int newvalue = value1 + value2 +10;
        intent.putExtra("V3",newvalue);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void finish(){
        super.finish();
    }
}