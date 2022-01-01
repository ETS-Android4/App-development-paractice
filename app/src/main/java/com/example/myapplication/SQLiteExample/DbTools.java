package com.example.myapplication.SQLiteExample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

public class DbTools extends SQLiteOpenHelper {
    public DbTools(Context context){
        super(context, "ContactsDB", null, 1);
    }

    View view;
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SqlCreateTable = "CREATE TABLE CONTACTS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "firstName TEXT," + "lastName TEXT," +
                "phoneNumber TEXT," + "emailAddress TEXT," +
                "homeAddress TEXT)";
        try{
            db.execSQL(SqlCreateTable);
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNewContact(@NonNull HashMap<String,String> contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", contact.get("_id"));
        contentValues.put("firstName", contact.get("firstName"));
        contentValues.put("lastName", contact.get("lastName"));
        contentValues.put("phoneNumber", contact.get("phoneNumber"));
        contentValues.put("emailAddress", contact.get("emailAddress"));
        contentValues.put("homeAddress", contact.get("homeAddress"));
        long i = db.insert("CONTACTS", null, contentValues);
        if (i != 1){
            Log.d("TAG","Data Insertion Successful");

        }
        else{
            Log.d("TAG","Data Insertion failed");
        }
    }

    public ArrayList<HashMap<String,String>> getAllContacts(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<HashMap<String,String>> contactList = new ArrayList<HashMap<String,String>>();
        String query = "SELECT * FROM CONTACTS ORDER BY firstName DESC";
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{
                HashMap<String,String> contact = new HashMap<String,String>();
                contact.put("_id", cursor.getString(0));
                contact.put("firstName", cursor.getString(1));
                contact.put("lastName", cursor.getString(2));
                contact.put("phoneNumber", cursor.getString(3));
                contact.put("emailAddress", cursor.getString(5));
                contact.put("homeAddress", cursor.getString(4));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        db.close();
        return contactList;
    }

    public HashMap<String,String> getSingleRecord (String id){
        SQLiteDatabase db = getReadableDatabase();
        HashMap<String,String> singleRecord = new HashMap<String,String>();
        String query = "SELECT * FROM CONTACTS WHERE _id = '" + id + "';";
        Cursor cursor = db.rawQuery(query, null);
        //Log.d("Cursor", String.valueOf(cursor.moveToFirst()));
        if (cursor.moveToFirst()){
            singleRecord.put("_id", cursor.getString(0));
            singleRecord.put("firstName", cursor.getString(1));
            singleRecord.put("lastName", cursor.getString(2));
            singleRecord.put("phoneNumber", cursor.getString(3));
            singleRecord.put("emailAddress", cursor.getString(4));
            singleRecord.put("homeAddress", cursor.getString(5));
        }
        db.close();
        return singleRecord;
    }

    public void DeleteRecord (String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("CONTACTS","_id = '"+ id + "'" ,null);
        Log.d("Delete", "Data has been deleted");
        db.close();
    }

    public void UpdateRecord (String id, ContentValues cv){
        SQLiteDatabase db = getWritableDatabase();
        db.update("CONTACTS",cv,"_id = '"+ id + "'" ,null);
        Log.d("Delete", "Data has been deleted");
        db.close();
    }

}
