package com.example.seancasey.softwaretestapplication;

import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.seancasey.softwaretestapplication.MyValues.SUPERVALU_PRICE_REGEX;
import static com.example.seancasey.softwaretestapplication.MyValues.SUPERVALU_URL_START;

/**
 * Created by Niamh on 13/12/2016.
 */

public class SuperValuProductPrice extends shopProductPrice {

	public String getPrices(String itemName)
	{
		String fixedString = fixString(itemName);
		String price = "";
		try {
			Scanner scanner = getScanner(fixedString);
			price = getPriceFromScanner(scanner);
			//Log.d("SVPRICE", price);

		}catch ( Exception ex ) {
			ex.printStackTrace();
		}
		return price;
	}

	private Scanner getScanner(String fixedString) throws IOException {
		URLConnection connection =  new URL(SUPERVALU_URL_START +fixedString).openConnection();
		return new Scanner(connection.getInputStream());
	}

	private static String getPriceFromScanner(Scanner scanner)
	{
		String price = "";
		while (scanner.hasNextLine())
		{
			final String fromHtml = scanner.nextLine();
			if (fromHtml.contains("price"))
			{
				price = getPriceFromHtml(fromHtml);
				break;
			}
		}
		return price;
	}

	private static String getPriceFromHtml(String html)
	{
		String price = "";
		Pattern p = Pattern.compile(SUPERVALU_PRICE_REGEX);
		Matcher m = p.matcher(html);
		boolean b = m.matches();
		if (b)
		{
			price = m.group(1);
		}
		return price;
	}


}
