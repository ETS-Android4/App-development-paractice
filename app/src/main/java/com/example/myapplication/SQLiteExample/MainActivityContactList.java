package com.example.myapplication.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityContactList extends AppCompatActivity {

    ListView listView;
    DbTools dbTools;
    TextView contactID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact_list);
        listView = findViewById(R.id.list);
        dbTools = new DbTools(getApplicationContext());

        ArrayList<HashMap<String,String>> AllContact = dbTools.getAllContacts();
        if (AllContact.size() != 0){
            SimpleAdapter arrayAdapter = new SimpleAdapter(this,
                    AllContact,R.layout.activity_contact_entery, new String [] {"_id","firstName","lastName"},
                    new int[] {R.id.textViewID, R.id.textViewFirstName, R.id.textViewLastName});
            listView.setAdapter(arrayAdapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditContactEntery.class);
                contactID = view.findViewById(R.id.textViewID);
                intent.putExtra("_id", contactID.getText().toString());
                Log.d("trial", contactID.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void AddContact(View view) {
        Intent intent = new Intent(this, NewContactActivity.class);
        startActivity(intent);
    }
}