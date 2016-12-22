package com.example.seancasey.softwaretestapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Linker {

    private int currentFragment; //to keep track of what fragment we're in now

    private FragmentManager fragmentManager; //for switching screens
    private Fragment fragment;
    private UserInputFragment userInputFragment;
    private DisplayFragment displayFragment;

    private ArrayList<String> productNames;
    private ArrayList<String> tescoProductPrices;
    private ArrayList<String> superValuProductPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputFragment = new UserInputFragment();
        displayFragment = new DisplayFragment();

        fragment = new Fragment();

        replaceFragments(MyValues.LOAD_TYPE_LIST_FRAGMENT);
    }

    public void replaceFragments(int myFragment)
    {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(myFragment == MyValues.LOAD_TYPE_LIST_FRAGMENT)
        {
            fragment = userInputFragment;
            currentFragment = MyValues.CURRENT_TYPE_LIST_FRAGMENT;
        }
        else if(myFragment == MyValues.LOAD_DISPLAY_FRAGMENT)
        {
            fragment = displayFragment;
            currentFragment = MyValues.CURRENT_DISPLAY_FRAGMENT;
        }
        transaction.replace(R.id.activity_main, fragment);
        transaction.commit();
    }

    public void onBackPressed()
    {
        if (currentFragment != MyValues.CURRENT_TYPE_LIST_FRAGMENT)
        {
            replaceFragments(MyValues.LOAD_TYPE_LIST_FRAGMENT);
        }
        else
        {
            super.onBackPressed();
        }
    }

    public void setTescoProductPrices(ArrayList<String> productPrices)
    {
        this.tescoProductPrices = productPrices;
    }

    public ArrayList<String> getTescoProductPrices()
    {
        return this.tescoProductPrices;
    }

    public void setSuperValuProductPrices(ArrayList<String> productPrices)
    {
        this.superValuProductPrices = productPrices;
    }

    public ArrayList<String> getSuperValuProductPrices()
    {
        return this.superValuProductPrices;
    }

    public void setProductNames(ArrayList<String> productNames)
    {
        this.productNames = productNames;
    }

    public ArrayList<String> getProductNames()
    {
        return productNames;
    }

    public UserInputFragment getUserInputFragment()
    {
        return userInputFragment;
    }
}