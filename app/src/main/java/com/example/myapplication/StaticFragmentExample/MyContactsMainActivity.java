package com.example.myapplication.StaticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

public class MyContactsMainActivity extends AppCompatActivity implements Contacts.ListSelectionListner{

    public static String[] contactsArray;
    public static String[] contactsDetailArray;

    public ContactsDetail contactsDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts_main);
        contactsArray  = getResources().getStringArray(R.array.contacts_array);
        contactsDetailArray = getResources().getStringArray(R.array.detail_array);
        contactsDetailFragment = (ContactsDetail) getSupportFragmentManager().findFragmentById(R.id.contactsdetail);
    }

    @Override
    public void onSelection(int position) {
        if (contactsDetailFragment.getShowIndex() != position){
            contactsDetailFragment.ContactIndex(position);
        }


    }
}