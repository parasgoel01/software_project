package com.example.seancasey.softwaretestapplication;


import java.util.ArrayList;

public interface Linker {

    void replaceFragments(int myFragment);

    void setProductPrices(ArrayList<String> productPrices);

    ArrayList<String> getProductPrices();

    void setProductNames(ArrayList<String> productNames);

    ArrayList<String> getProductNames();
}