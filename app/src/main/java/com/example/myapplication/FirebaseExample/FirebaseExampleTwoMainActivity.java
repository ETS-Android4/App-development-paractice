package com.example.myapplication.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseExampleTwoMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase db;
    MyFirebasrAdapter firebasrAdapter;
    ArrayList<Fast_Student> fast_studentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example_two_main);
        //binding view
        recyclerView = findViewById(R.id.myfirebaserecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        db = FirebaseDatabase.getInstance("https://myfirstproject-542df-default-rtdb.firebaseio.com/");
        reference = db.getReference("Student");
        fast_studentArrayList = new ArrayList<>();
        LoadData();
    }

    public void LoadData(){

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot P_Snapshot) {
                Clear();
                Fast_Student fast_student;
                for(DataSnapshot C_snapshot: P_Snapshot.getChildren()){
                    fast_student =new Fast_Student();
                    fast_student.setName(C_snapshot.child("Name").getValue().toString());
                    fast_student.setURL(C_snapshot.child("Picture").getValue().toString());
                    fast_studentArrayList.add(fast_student);
                }
                firebasrAdapter = new MyFirebasrAdapter(fast_studentArrayList,getApplicationContext());
                recyclerView.setAdapter(firebasrAdapter);
                firebasrAdapter.notifyDataSetChanged();
            }

            public void Clear(){
                if (fast_studentArrayList != null){
                    fast_studentArrayList.clear();
                    if (firebasrAdapter != null){
                        firebasrAdapter.notifyDataSetChanged();
                    }
                }
                else{
                    fast_studentArrayList = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
