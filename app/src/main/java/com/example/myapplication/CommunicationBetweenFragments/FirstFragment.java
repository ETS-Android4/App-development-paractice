package com.example.myapplication.CommunicationBetweenFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class FirstFragment extends Fragment {
    ButtonPressListner.OnButtonPressListner buttonPressListner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.first_fragment,container,false);
        myfunction(root);
        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListner = (ButtonPressListner.OnButtonPressListner) getActivity();
    }

    void myfunction(ViewGroup root){
        TextView textView = root.findViewById(R.id.fragmenttext);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView.setText("Message from first fragment!");
                buttonPressListner.onButtonPressed("Message from Firt Fragment");
            }
        });
    }
}
