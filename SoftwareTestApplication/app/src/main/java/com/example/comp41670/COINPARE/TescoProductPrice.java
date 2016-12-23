package com.example.comp41670.COINPARE;

import android.annotation.TargetApi;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static com.example.comp41670.COINPARE.MyValues.NO_PRICE_FOUND;
import static com.example.comp41670.COINPARE.MyValues.SUBSCRIPTION_KEY_VALUE;
import static com.example.comp41670.COINPARE.MyValues.TESCO_SUBSCRIPTION_KEY;
import static com.example.comp41670.COINPARE.MyValues.TESCO_URL_END;
import static com.example.comp41670.COINPARE.MyValues.TESCO_URL_START;

public class TescoProductPrice extends ShopProductPrice {


    // call methods to format string and to find product price
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String getIndividualProductPrice(String itemName)
    {
        String productPriceFound = NO_PRICE_FOUND;
        String fixedString = fixString(itemName);
        try {
            productPriceFound = getProductPrice(fixedString);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return productPriceFound;
    }

    // From product price using Tesco API
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private String getProductPrice(String fixedString) throws IOException {
        String foundPrice = NO_PRICE_FOUND;
        InputStream response = getResponse(fixedString);
        try (Scanner scanner = new Scanner(response)) {
            String responseBody = getResponseBody(scanner);
            try {
                JSONObject object = new JSONObject(responseBody);
                JSONArray array = object.getJSONObject("uk").getJSONObject("ghs").getJSONObject("products").getJSONArray("results");
                if (array.length() == 0) //if no price is found return message
                {
                    return foundPrice;
                }

                JSONObject item = (JSONObject)array.get(0);
                foundPrice = item.get("price").toString();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return foundPrice;
    }

    private String getResponseBody(Scanner scanner) {
        return scanner.useDelimiter("\\A").next();
    }

    private InputStream getResponse(String fixedString) throws IOException {
        String fullString = TESCO_URL_START+fixedString+TESCO_URL_END;
        URLConnection connection = new URL(fullString).openConnection();
        connection.setRequestProperty(TESCO_SUBSCRIPTION_KEY, SUBSCRIPTION_KEY_VALUE);
        return connection.getInputStream();
    }

}
