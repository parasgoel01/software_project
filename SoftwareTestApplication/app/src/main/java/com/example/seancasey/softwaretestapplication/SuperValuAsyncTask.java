package com.example.seancasey.softwaretestapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Niamh on 13/12/2016.
 */

public class SuperValuAsyncTask extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {
	protected ArrayList<String> doInBackground(ArrayList<String>... params) {

		ArrayList<String> listOfPrices = new ArrayList<>();
		for (String item:params[0])
		{
			String price = SuperValuGetPrice.getPrices(item);
			listOfPrices.add(price);
		}
		return listOfPrices;
	}

	protected void onPostExecute(ArrayList<String> result) //ASK
	{

	}
}
