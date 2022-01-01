package com.example.myapplication.Filehandling_Example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileHandling_MainActivity extends AppCompatActivity {
    EditText edittext;
    TextView textview;
    String FileName= "MyTextFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling_main);
        edittext =findViewById(R.id.edt);
        textview = findViewById(R.id.txt_filedata);
    }

    public void SaveData(View view) {
        String Data =edittext.getText().toString();
        FileOutputStream FOS;
        try {
            FOS = openFileOutput(FileName, Context.MODE_PRIVATE);
            FOS.write(Data.getBytes());
            edittext.setText("");
            Snackbar.make(view,"Data Saved",Snackbar.LENGTH_LONG).show();
            FOS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowData(View view) {
        String ReadData = "";
        try {
            FileInputStream inputStream = openFileInput(FileName);
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(reader);
            String value = bufferReader.readLine();
            if (value == null ){
                Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
            }
            else{
                while(value != null){
                    ReadData = ReadData + value;
                    value = bufferReader.readLine();
                }
                bufferReader.close();
                reader.close();
                inputStream.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textview.setText(ReadData);
    }
}