package com.example.myapplication.AsyncTaskClassExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.concurrent.ExecutionException;

public class WebContentDownload extends AppCompatActivity {

    EditText multilineText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content_download);
        //binding
        multilineText = findViewById(R.id.edtmultilinewebcontent);
    }


    class DownloadWebContent extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.d("TAG", "DoInBackground in progress");
            try {
                URL url = new URL(strings[0]);
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    int data = reader.read();
                    String webcontent ="";
                    while (data != -1){
                        char ch = (char) data;
                        webcontent += ch;
                        data = reader.read();
                    }
                    return webcontent;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    public void LoadWebContent(View view) {
        DownloadWebContent obj = new DownloadWebContent();
        try {
            String CompleteWebContent = obj.execute("https://cfd.nu.edu.pk/").get();
            Log.d("TAG","Back in main");
            multilineText.setText(CompleteWebContent);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}