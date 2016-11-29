package com.example.seancasey.softwaretestapplication;

import android.os.AsyncTask;

import java.net.URL;

public class TescoAsyncTask extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... params) {

        //String item = "milk";
        String price = TescoGetPrice.getPrices(params[0]);

        return price;
    }

    protected void onPostExecute(String result)
    {

    }
}
