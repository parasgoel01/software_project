package com.example.seancasey.softwaretestapplication;

import android.os.AsyncTask;

/**
 * Created by Niamh on 13/12/2016.
 */

public class SuperValuAsyncTask extends AsyncTask<String, Void, String> {
	protected String doInBackground(String... params) {
		String price = SuperValuGetPrice.getPrices(params[0]);
		return price;
	}

	protected void onPostExecute(String result)
	{

	}
}
