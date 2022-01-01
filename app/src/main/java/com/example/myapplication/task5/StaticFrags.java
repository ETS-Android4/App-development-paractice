package com.example.myapplication.task5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class StaticFrags extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_frags);
    }

    public void Dwnimg(View view) {
        //Imageviewfrag FirstFragment = (Imageviewfrag) getSupportFragmentManager().findFragmentById(R.id.frag_1);
        //assert FirstFragment != null;
        //FirstFragment.OnFragmentInteraction("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ_nNZp_IIW9v0VP2YY5pVFtQkjhoP0-OcDg&usqp=CAU");

        //Imageviewfrag SecondFragment = (Imageviewfrag) getSupportFragmentManager().findFragmentById(R.id.frag_2);
        //assert SecondFragment != null;
        //SecondFragment.OnFragmentInteraction("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg");

        //Imageviewfrag ThirdFragment = (Imageviewfrag) getSupportFragmentManager().findFragmentById(R.id.frag_3);
        //assert ThirdFragment != null;
        //ThirdFragment.OnFragmentInteraction("https://www.ixpap.com/images/2021/03/minimalist-wallpaper-ixpap.png");

        //Imageviewfrag FourthFragment = (Imageviewfrag) getSupportFragmentManager().findFragmentById(R.id.frag_4);
        //assert FourthFragment != null;
        //FourthFragment.OnFragmentInteraction("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dmlld3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80");

        //Imageviewfrag FivethFragment = (Imageviewfrag) getSupportFragmentManager().findFragmentById(R.id.frag_5);
        //assert FivethFragment != null;
        //FivethFragment.OnFragmentInteraction("https://www.whatsappprofiledpimages.com/wp-content/uploads/2019/08/Attitude-Images-photo-pictures-download-169x300.gif");

        //Imageviewfrag SixthFragment = (Imageviewfrag) getSupportFragmentManager().findFragmentById(R.id.frag_6);
        //assert SixthFragment != null;
        //SixthFragment.OnFragmentInteraction("https://www.whatsappprofiledpimages.com/wp-content/uploads/2019/08/Attitude-Images-photo-pictures-download-169x300.gif");
    }
}