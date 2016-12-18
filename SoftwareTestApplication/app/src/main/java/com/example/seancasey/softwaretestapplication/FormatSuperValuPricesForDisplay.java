package com.example.seancasey.softwaretestapplication;

import java.util.ArrayList;

/**
 * Created by seancasey on 18/12/2016.
 */

public class FormatSuperValuPricesForDisplay extends FormatPricesForDisplay {

    public ArrayList<Double> getPricesAsDoubles(ArrayList<String> stringPrices)
    {
        ArrayList<Double> doublePrices = new ArrayList<>();
        for (String stringPrice:stringPrices)
        {
            double doublePrice = Double.valueOf(stringPrice);
            doublePrices.add(doublePrice);
        }
        return doublePrices;
    }

}
