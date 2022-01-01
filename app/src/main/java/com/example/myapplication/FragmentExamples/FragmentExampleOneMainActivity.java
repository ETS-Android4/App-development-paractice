package com.example.myapplication.FragmentExamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.myapplication.R;

public class FragmentExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_example_one_main);
        Configuration config = getResources().getConfiguration();
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LM_Fragment lm_fragment = new LM_Fragment();
            FT.replace(android.R.id.content,lm_fragment);
        }
        else{
            PM_Fragment pm_fragment = new PM_Fragment();
            FT.replace(android.R.id.content,pm_fragment);
        }

        FT.commit();
    }
}