package com.example.seancasey.softwaretestapplication;

import java.util.ArrayList;

/**
 * Created by seancasey on 18/12/2016.
 */

public class TescoGetPricesInputted extends GetPricesInputted {

    public shopProductPrice getShopProductPrice()
    {
        return new TescoProductPrice();
    }

    public ArrayList<String> getShopPrices(ArrayList<String> itemsToSearchFor)
    {
        TescoGetPricesInputted tescoGetPricesInputted = new TescoGetPricesInputted(); //ASK (static?)
        return tescoGetPricesInputted.getPricesInputted(itemsToSearchFor);
    }
}
