package com.example.myapplication.CommunicationBetweenFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.myapplication.R;

public class CommunicationExampleMainActivity extends FragmentActivity implements ButtonPressListner.OnButtonPressListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_example_main);
    }

    @Override
    public void onButtonPressed(String message) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.frag_2);
        secondFragment.OnFragmentInteraction(message);
    }
}