package com.example.seancasey.softwaretestapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by seancasey on 18/12/2016.
 */

public abstract class ShopProductPrice extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {

    ProgressDialog progressDialog;

    protected String fixString(String itemName) //SHOULD THIS BE STATIC????
    {
        return itemName.replaceAll("\\s+", "\\+");
    }

    protected void onPostExecute(ArrayList<String> result) //ASK
    {

    }

    protected void onPreExecute()
    {

        //progressDialog = new ProgressDialog(new MyContextWrapper());
        //progressDialog.setMessage("in progress...");
        //progressDialog.show();
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
