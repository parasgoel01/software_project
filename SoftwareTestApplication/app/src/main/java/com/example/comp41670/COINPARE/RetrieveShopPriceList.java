package com.example.comp41670.COINPARE;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by seancasey on 19/12/2016.
 */

public abstract class RetrieveShopPriceList {


    protected ArrayList<String> productPrices(ArrayList<String> itemsToSearchFor)
    {
        ArrayList<String> shopPrices = new ArrayList<String>();

        ShopProductPrice shopProductPrice = getShopProductPrice();

        try{
            shopPrices = shopProductPrice.execute(itemsToSearchFor).get();
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

    public abstract ShopProductPrice getShopProductPrice();
}
