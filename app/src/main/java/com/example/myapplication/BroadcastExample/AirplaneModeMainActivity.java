package com.example.myapplication.BroadcastExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.myapplication.R;

public class AirplaneModeMainActivity extends AppCompatActivity {
    AirplaneModeReceiver obj = new AirplaneModeReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airplane_mode_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(obj , intentFilter);
    }



    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(obj);
    }
}