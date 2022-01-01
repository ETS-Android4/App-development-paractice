package com.example.myapplication.IntentExamples;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class FistActivity extends AppCompatActivity {

    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist);
        textview = findViewById(R.id.txtfirstactivity);
    }

     public void GOTO (View view){

//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:"+123456));
//        startActivity(intent);

//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("https://www.google.com"));
//        startActivity(intent);

        Intent intent = new Intent(this,SecodActivity.class);
        intent.putExtra("V1",5);
        intent.putExtra("V2", 5);
        MyResult.launch(intent);
//        startActivityForResult(intent,101);
     }

    ActivityResultLauncher<Intent> MyResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult()
                    , new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK){
                                Intent value = result.getData();
                                int newvalue = value.getIntExtra("V3",5);
                                Toast.makeText(FistActivity.this, "Back in Main : "+newvalue, Toast.LENGTH_SHORT).show();
                            }
//                            Toast.makeText(FistActivity.this, "Back in Main", Toast.LENGTH_SHORT).show();
//                            Log.d("TAG","My Activity");
                        }
                    });

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK && requestCode == 101){
//            if(data.hasExtra("V3")){
//                textview.setText(data.getExtras().getString("V3"));
//            }
//        }
//    }

}