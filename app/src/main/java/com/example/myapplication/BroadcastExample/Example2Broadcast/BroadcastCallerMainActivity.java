package com.example.myapplication.BroadcastExample.Example2Broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;

public class BroadcastCallerMainActivity extends AppCompatActivity {

    MyReceiverCaller obj = new MyReceiverCaller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_caller_main);
        Intent intent = new Intent(this,MyReceiverCaller.class);
        sendBroadcast(intent);
    }

}