package com.example.myapplication.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class NewContactActivity extends AppCompatActivity {

    DbTools dbTools;
    View view;
    EditText firstName,lastName,phoneNumber, emailAddress,homeAddress;
    Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        dbTools = new DbTools((getApplicationContext()));
        //Snackbar.make(view, "Database ok", Snackbar.LENGTH_LONG).show();

        firstName = findViewById(R.id.edtfirstname);
        lastName = findViewById(R.id.edtsecondname);
        phoneNumber = findViewById(R.id.edtphonenumber);
        emailAddress = findViewById(R.id.edtemail);
        homeAddress = findViewById(R.id.edthomeaddress);
        buttonSave =findViewById(R.id.btnsave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> contact = new HashMap<>();
                contact.put("firstName", firstName.getText().toString());
                contact.put("lastName", lastName.getText().toString());
                contact.put("phoneNumber", phoneNumber.getText().toString());
                contact.put("emailAddress", emailAddress.getText().toString());
                contact.put("homeAddress", homeAddress.getText().toString());
                dbTools.addNewContact(contact);
                Intent intent =  new Intent(getApplicationContext(),MainActivityContactList.class);
                startActivity(intent);
            }
        });
    }
}