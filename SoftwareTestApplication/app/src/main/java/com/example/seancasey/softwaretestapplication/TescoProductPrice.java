package com.example.seancasey.softwaretestapplication;

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

import static com.example.seancasey.softwaretestapplication.MyValues.SUBSCRIPTION_KEY_VALUE;
import static com.example.seancasey.softwaretestapplication.MyValues.TESCO_SUBSCRIPTION_KEY;
import static com.example.seancasey.softwaretestapplication.MyValues.TESCO_URL_END;
import static com.example.seancasey.softwaretestapplication.MyValues.TESCO_URL_START;

public class TescoProductPrice extends shopProductPrice {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String getPrices(String itemName)
    {
        String foundPrice = "";
        String fixedString = fixString(itemName);
        try {
            foundPrice = getFoundPrice(fixedString);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); // ASK
        }
        return foundPrice; //ASK
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private String getFoundPrice(String fixedString) throws IOException {
        String foundPrice = "";
        InputStream response = getResponse(fixedString);
        try (Scanner scanner = new Scanner(response)) {
            String responseBody = getResponseBody(scanner);
            try {
                JSONObject object = new JSONObject(responseBody);
                JSONArray array = object.getJSONObject("uk").getJSONObject("ghs").getJSONObject("products").getJSONArray("results");
                JSONObject item = (JSONObject)array.get(0);
                foundPrice = item.get("price").toString(); //ASK

            } catch (JSONException e) {
                // TODO Auto-generated catch block
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
