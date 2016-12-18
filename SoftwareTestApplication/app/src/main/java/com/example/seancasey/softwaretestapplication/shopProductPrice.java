package com.example.seancasey.softwaretestapplication;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by seancasey on 18/12/2016.
 */

public abstract class shopProductPrice extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {

    protected static String fixString(String itemName)
    {
        return itemName.replaceAll("\\s+", "\\+");
    }

    protected void onPostExecute(ArrayList<String> result) //ASK
    {

    }

    protected ArrayList<String> doInBackground(ArrayList<String>... params) {

        ArrayList<String> listOfPrices = new ArrayList<>();
        for (String item:params[0])
        {
            String price = getPrices(item);
            listOfPrices.add(price);
        }
        return listOfPrices;
    }

    public abstract String getPrices(String itemName);

}
