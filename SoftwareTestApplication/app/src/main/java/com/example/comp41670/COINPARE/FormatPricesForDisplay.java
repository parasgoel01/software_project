package com.example.comp41670.COINPARE;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.EURO_SYMBOL;
import static java.lang.Math.round;

/**
 * Created by seancasey on 18/12/2016.
 */

public abstract class FormatPricesForDisplay {

    public String getFormattedTotalPrice(ArrayList<String> stringPrices)
    {
        ArrayList<Double> doublePrices = getPricesAsDoubles(stringPrices);
        return EURO_SYMBOL + getTotalPrice(doublePrices);
    }

    public String getFormattedBreakdownPrices(ArrayList<String> stringPrices)
    {
        ArrayList<Double> doublePrices = getPricesAsDoubles(stringPrices);
        return getFormattedPrices(doublePrices);
    }

    public double getTotalPrice(ArrayList<Double> prices)
    {
        double totalCost = 0.0;
        for (double price:prices)
        {
            totalCost+=price;
        }
        return roundToNearestCent(totalCost);
    }

    public abstract ArrayList<Double> getPricesAsDoubles(ArrayList<String> stringPrices);

    protected String getFormattedPrices(ArrayList<Double> prices)
    {
        String breakdownPrices = "";
        for (double price:prices)
        {
            breakdownPrices +=  EURO_SYMBOL + price + "\n";
        }
        return breakdownPrices;
    }

    protected double roundToNearestCent(double price) {
        price = round(price*100.0)/100.0;
        return price;
    }
}
