package com.example.comp41670.COINPARE;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public abstract class RetrieveShopPriceList {

    // method to get an arraylist of product prices from an arraylist of products
    protected ArrayList<String> productPrices(ArrayList<String> itemsToSearchFor)
    {
        ArrayList<String> shopPrices = new ArrayList<>();

        ShopProductPrice shopProductPrice = getShopProductPrice();

        try{
            shopPrices = shopProductPrice.execute(itemsToSearchFor).get(); //starting the AsyncTask for accessing the internet
        }
        catch(InterruptedException ex1)
        {
            ex1.printStackTrace();
        }
        catch (ExecutionException ex2)
        {
            ex2.printStackTrace();
        }
        return shopPrices;
    }

    // method to get the product price for a shop (defined in subclasses for SuperValu and Tesco)
    public abstract ShopProductPrice getShopProductPrice();
}
