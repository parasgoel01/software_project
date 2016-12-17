package com.example.seancasey.softwaretestapplication;

import android.content.Context;
import android.util.Log;
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

public class SuperValuGetPrice {

	public static String getPrices(String itemName)
    {
        String fixedString = fixString(itemName);
        URLConnection connection = null;
        String price = "";
        fixedString = "milk";
        try {
            connection =  new URL("https://shop.supervalu.ie/shopping/search/allaisles?q="+fixedString).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            price = getPriceFromScanner(scanner);

        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return price;
    }

    private static String fixString(String itemName)
    {
        return itemName.replaceAll("\\s+", "\\+");
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
        Pattern p = Pattern.compile(".*?(\\d+(\\.\\d+)*).*");
        Matcher m = p.matcher(html);
        boolean b = m.matches();
        if (b)
        {
            price = m.group(1);
        }
        return price;
    }
}