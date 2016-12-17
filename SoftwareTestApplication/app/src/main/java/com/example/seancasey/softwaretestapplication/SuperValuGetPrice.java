package com.example.seancasey.softwaretestapplication;

import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Niamh on 13/12/2016.
 */

/*public class SuperValuGetPrice {
	public static String getPrices(String itemName)
	{
		try {
			String fullString = "https://shop.supervalu.ie/shopping/search/allaisles?q="+itemName+"";
			URLConnection connection = new URL(fullString).openConnection();
			InputStream response = connection.getInputStream();
			try (Scanner scanner = new Scanner(response)) {
				String responseBody = scanner.useDelimiter("\\A").next();
				//System.out.println(responseBody);
				try {
					JSONObject object = new JSONObject(responseBody);

		//Pattern p = Pattern.compile(".*[p]rice\\:(\\d+\\.\\d+)");
		Pattern p = Pattern.compile(".*?[p]rice\\:(\\d+(\\.\\d+)*).*");

		String myString = "Find the first price10.8 Hello price:9.3 nextprice:11.1123";
		Matcher m = p.matcher(myString);
		boolean b = m.matches();
		String newString = null;
		if (b)
		{
			newString = m.group(1);
			Toast.makeText(getActivity(), "YES, PRICE = " + newString, Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(getActivity(), "NO", Toast.LENGTH_SHORT).show();
		}
	}
}
*/