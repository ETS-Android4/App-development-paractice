package com.example.myapplication.IntentActions;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImagePickerMainActivity extends AppCompatActivity {

    ImageView imageview;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker_main);
        imageview = findViewById(R.id.imgpicker);
    }

    public void PICKImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        intent.addCategory(intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 101);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 101 && resultCode == RESULT_OK){
            try {

                InputStream inputStream = getContentResolver()
                        .openInputStream(data.getData());
                if (bitmap != null){
                    bitmap.recycle();
                }
                bitmap = BitmapFactory.decodeStream(inputStream);
                imageview.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}