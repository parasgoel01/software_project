package com.example.comp41670.COINPARE;


import java.util.ArrayList;

// interface for facilitating interaction between the two fragments and the main activity
public interface Linker {

    void replaceFragments(int myFragment);

    void setTescoProductPrices(ArrayList<String> productPrices);

    ArrayList<String> getTescoProductPrices();

    void setSuperValuProductPrices(ArrayList<String> productPrices);

    ArrayList<String> getSuperValuProductPrices();

    void setProductNames(ArrayList<String> productNames);

    ArrayList<String> getProductNames();

}