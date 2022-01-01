package com.example.myapplication.StaticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ContactsDetail extends Fragment {
    public TextView contactDetailTextView;
    int currentIndex = -1;
    int arraylength;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactsdetail,container,false);
    }

    public int getShowIndex(){
        return currentIndex;
    }

    public void ContactIndex(int Index){
        if (Index < 0 || Index >= arraylength){
            return;
        }
        currentIndex = Index;
        contactDetailTextView.setText(MyContactsMainActivity.contactsDetailArray[currentIndex]);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contactDetailTextView = getActivity().findViewById(R.id.contactsdetailtextview);
        arraylength = MyContactsMainActivity.contactsArray.length;
    }
}
