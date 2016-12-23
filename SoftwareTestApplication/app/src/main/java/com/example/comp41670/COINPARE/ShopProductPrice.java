package com.example.comp41670.COINPARE;

import android.os.AsyncTask;

import java.util.ArrayList;


public abstract class ShopProductPrice extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {

    @Override
    protected ArrayList<String> doInBackground(ArrayList<String>... itemsToSearchFor)
    {

        ArrayList<String> listOfProductPrices = new ArrayList<>();
        for (String item:itemsToSearchFor[0])
        {
            String price = getIndividualProductPrice(item);
            listOfProductPrices.add(price);
        }
        return listOfProductPrices;
    }

    @Override
    protected void onPostExecute(ArrayList<String> result)
    {

    }

    public abstract String getIndividualProductPrice(String itemName);

    // method to replace spaces in strings with + symbols (as is required by the URLConnection class)
    protected String fixString(String itemName)
    {
        return itemName.replaceAll("\\s+", "\\+");
    }


}
