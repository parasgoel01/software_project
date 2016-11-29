package com.example.seancasey.softwaretestapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements Linker {

    //private method2
    private int currentFragment; //to keep track of what fragment we're in now

    private FragmentManager fragmentManager; //for switching screens
    private HomeFragment homeFragment;
    private TypeListFragment typeListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MORE STUFF

        //setup fragment method2...
        currentFragment = R.id.activity_main;
        homeFragment = new HomeFragment();
        typeListFragment = new TypeListFragment();

        //launch the home fragment
        Fragment fragment;
        fragment = homeFragment;

        // Got this method2 online...
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity_main, fragment);
        transaction.commit();
    }

    public void replaceFragments()
    {
        typeListFragment = new TypeListFragment();
        Fragment fragment;
        fragment = typeListFragment;
        fragmentManager.beginTransaction().replace(R.id.activity_main, typeListFragment).commit();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity_main, fragment);
    }
}