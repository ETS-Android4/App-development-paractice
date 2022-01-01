package com.example.myapplication.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

import java.util.HashMap;

public class EditContactEntery extends AppCompatActivity {

    DbTools dbTools;
    String id = null;
    EditText firstName, lastName, phoneNumber, emailAddress, homeAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_entery);
        firstName = findViewById(R.id.editfirstname);
        lastName = findViewById(R.id.editsecondname);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailAddress = findViewById(R.id.editemailaddress);
        homeAddress = findViewById(R.id.edithomeaddress);
        dbTools = new DbTools(getApplicationContext());
        Intent intent = getIntent();
        id = intent.getExtras().getString("_id");
        HashMap <String,String> singleRecord = dbTools.getSingleRecord(id);
        if(singleRecord.size() != 0){
            firstName.setText(singleRecord.get("firstName"));
            lastName.setText(singleRecord.get("lastName"));
            phoneNumber.setText(singleRecord.get("phoneNumber"));
            emailAddress.setText(singleRecord.get("emailAddress"));
            homeAddress.setText(singleRecord.get("homeAddress"));
        }
    }

    public void DeleteData(View view) {
        dbTools.DeleteRecord(id);
        Intent intent =  new Intent(getApplicationContext(),MainActivityContactList.class);
        Log.d("Delete", "Data deleted");
        startActivity(intent);
    }

    public void UpdateData(View view) {
        firstName = findViewById(R.id.editfirstname);
        lastName = findViewById(R.id.editsecondname);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailAddress = findViewById(R.id.editemailaddress);
        homeAddress = findViewById(R.id.edithomeaddress);
        String fname, lname, num,email,address;
        fname = firstName.getText().toString();
        lname = lastName.getText().toString();
        num = phoneNumber.getText().toString();
        email = emailAddress.getText().toString();
        address = homeAddress.getText().toString();
        ContentValues cv = new ContentValues();
        if (!fname.matches("")){
            cv.put("firstName", fname);
        }
        if (!lname.matches("")) {
            cv.put("lastName", lname);
        }
        if (!num.matches("")) {
            cv.put("phoneNumber", num);
        }
        if (!email.matches("")) {
            cv.put("emailAddress", email);
        }
        if (!address.matches("")) {
            cv.put("homeAddress", address);
        }
        dbTools.UpdateRecord(id,cv);
        Intent intent =  new Intent(getApplicationContext(),MainActivityContactList.class);
        Log.d("Update", "Data updated");
        startActivity(intent);
    }
}