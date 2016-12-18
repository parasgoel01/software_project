package com.example.seancasey.softwaretestapplication;


import java.util.ArrayList;

public interface Linker {

    void replaceFragments(int myFragment);

    void setTescoProductPrices(ArrayList<String> productPrices);

    ArrayList<String> getTescoProductPrices();

    void setSuperValuProductPrices(ArrayList<String> productPrices);

    ArrayList<String> getSuperValuProductPrices();

    void setProductNames(ArrayList<String> productNames);

    ArrayList<String> getProductNames();
}