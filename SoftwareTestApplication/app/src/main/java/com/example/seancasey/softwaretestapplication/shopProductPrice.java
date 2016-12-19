package com.example.seancasey.softwaretestapplication;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by seancasey on 18/12/2016.
 */

public abstract class ShopProductPrice extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {

    protected static String fixString(String itemName)
    {
        return itemName.replaceAll("\\s+", "\\+");
    }

    protected void onPostExecute(ArrayList<String> result) //ASK
    {

    }

    protected ArrayList<String> doInBackground(ArrayList<String>... params) {

        ArrayList<String> listOfProductPrices = new ArrayList<>();
        for (String item:params[0])
        {
            String price = getIndividualProductPrice(item);
            listOfProductPrices.add(price);
        }
        return listOfProductPrices;
    }

    public abstract String getIndividualProductPrice(String itemName);

}
