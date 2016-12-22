package com.example.comp41670.COINPARE;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.EXCHANGE_RATE;
import static java.lang.Math.round;

/**
 * Created by seancasey on 18/12/2016.
 */

public class FormatTescoPricesForDisplay extends FormatPricesForDisplay {

    public double poundToEuro(double pound)
    {
        return roundToNearestCent(pound * EXCHANGE_RATE);
    }

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
