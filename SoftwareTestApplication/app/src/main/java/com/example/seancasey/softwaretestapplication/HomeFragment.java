package com.example.seancasey.softwaretestapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment; //todo change this later
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class HomeFragment extends Fragment {

    private View myInflatedView;
    private Button button;
    private Linker linker;

    private int x;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myInflatedView = inflater.inflate(R.layout.fragment_home, container, false);
        linker = (Linker) getActivity();

        button = (Button)myInflatedView.findViewById(R.id.button);
        x = 0;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x+=1;
                button.setText(String.format(Locale.UK, "%d", x));
                linker.replaceFragments();

            }
        });


        return myInflatedView;
    }
}