package com.example.seancasey.softwaretestapplication;

import java.util.ArrayList;

/**
 * Created by seancasey on 18/12/2016.
 */

public class SuperValuGetPricesInputted extends GetPricesInputted {

    public shopProductPrice getShopAsyncTask()
    {
        return new SuperValuProductPrice();
    }

    public ArrayList<String> getShopPrices(ArrayList<String> itemsToSearchFor)
    {
        SuperValuGetPricesInputted superValuGetPricesInputted = new SuperValuGetPricesInputted(); //ASK (static?)
        return superValuGetPricesInputted.getPricesInputted(itemsToSearchFor);
    }

}
