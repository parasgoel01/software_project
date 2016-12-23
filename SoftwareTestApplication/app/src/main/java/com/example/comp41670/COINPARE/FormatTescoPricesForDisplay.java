package com.example.comp41670.COINPARE;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.EXCHANGE_RATE;


public class FormatTescoPricesForDisplay extends FormatPricesForDisplay {

    // method to convert prices from pound to euro
    public double poundToEuro(double pound)
    {
        return roundToNearestCent(pound * EXCHANGE_RATE);
    }

    // method to get the prices as an arraylist of doubles from string in the right currency (euro)
    public ArrayList<Double> getPricesAsDoubles(ArrayList<String> stringPrices)
    {
        ArrayList<Double> doublePrices = new ArrayList<>();
        for (String stringPrice:stringPrices)
        {
            double doublePrice = Double.valueOf(stringPrice);
            doublePrice = poundToEuro(doublePrice);
            doublePrices.add(doublePrice);
        }
        return doublePrices;
    }

}
