package com.example.seancasey.softwaretestapplication;

import android.os.AsyncTask;
import java.util.ArrayList;

public class TescoAsyncTask extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {

    protected ArrayList<String> doInBackground(ArrayList<String>... params) {

        ArrayList<String> listOfPrices = new ArrayList<>();
        for (String item:params[0])
        {
            String price = TescoGetPrice.getPrices(item);
            listOfPrices.add(price);
        }
        return listOfPrices;
    }

    protected void onPostExecute(ArrayList<String> result) //ASK
    {

    }
}
