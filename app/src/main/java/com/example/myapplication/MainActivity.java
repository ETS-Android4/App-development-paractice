package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button0,button1;
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout_example);
        button0 = findViewById(R.id.btn1);
        button0.setOnClickListener(this);
        button1 = findViewById(R.id.btn2);
        button1.setOnClickListener(this);
        edittext = findViewById(R.id.edtvalue);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn1:
                Toast.makeText(this, "Achaaa!!!! Button 0 OnClick listener", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this, "Achaaa!!!! Button 1 OnClick listener", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void Go(View view) {
        String value = edittext.getText().toString();
        Intent intent = new Intent (this, ex_imgview.class);
        intent.putExtra("Key",value);
        startActivity(intent);
    }
}