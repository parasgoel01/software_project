package com.example.seancasey.softwaretestapplication;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by seancasey on 18/12/2016.
 */

public abstract class GetPricesInputted {

    public ArrayList<String> getPricesInputted(ArrayList<String> itemsToSearchFor)
    {
        ArrayList<String> prices = new ArrayList<>();
        //TescoProductPrice tescoAsyncTask = new TescoProductPrice();
        shopProductPrice shopProductPrice = getShopAsyncTask();
        try
        {
            prices = shopProductPrice.execute(itemsToSearchFor).get();
        }
        catch(InterruptedException ex1)
        {
            ex1.printStackTrace();
        }
        catch (ExecutionException ex2)
        {
            ex2.printStackTrace();
        }
        return prices;
    }

    public abstract shopProductPrice getShopAsyncTask();
    public abstract ArrayList<String> getShopPrices(ArrayList<String> itemsToSearchFor);

}
