package com.example.comp41670.COINPARE;

import java.util.ArrayList;

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
