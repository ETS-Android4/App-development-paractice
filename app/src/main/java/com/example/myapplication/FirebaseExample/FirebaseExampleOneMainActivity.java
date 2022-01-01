package com.example.myapplication.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseExampleOneMainActivity extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://myfirstproject-542df-default-rtdb.firebaseio.com/");
    DatabaseReference myReference = db.getReference("Student");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example_one_main);

        //myReference.setValue("Abdullah is a ****boy");
/*        myReference.child("SMD").child("Student").setValue("Ali");
        myReference.child("SMD").child("Bitch").setValue("on the left");*/
    }


    public void GetData(View view) {
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String value = dataSnapshot.getValue().toString();
                    Log.d("TAG",""+value);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}