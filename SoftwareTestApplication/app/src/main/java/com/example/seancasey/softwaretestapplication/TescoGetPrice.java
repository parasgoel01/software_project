package com.example.seancasey.softwaretestapplication;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class TescoGetPrice {
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String getPrices(String itemName)
    {
        try {
            String fullString = "https://dev.tescolabs.com/grocery/products/?query="+itemName+"&offset=0&limit=10";
            URLConnection connection = new URL(fullString).openConnection();
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", "3e3f4b70e52743f19ed51bed179a212c");
            InputStream response = connection.getInputStream();
            try (Scanner scanner = new Scanner(response)) {
                String responseBody = scanner.useDelimiter("\\A").next();
                //System.out.println(responseBody);
                try {
                    JSONObject object = new JSONObject(responseBody);

                    JSONArray array = object.getJSONObject("uk").getJSONObject("ghs").getJSONObject("products").getJSONArray("results");
                    for(int i =0; i < array.length(); i++){
                        JSONObject item = (JSONObject)array.get(i);

                        //System.out.println("Name: "+item.get("name"));
                        //System.out.println("Price: "+item.get("price"));
                        Log.d("ABCD", item.get("name").toString());
                    }
                    JSONObject item = (JSONObject)array.get(0);
                    return item.get("price").toString();


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "SOMETHING";
    }
}
