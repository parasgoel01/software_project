package com.example.comp41670.COINPARE;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.EURO_SYMBOL;
import static java.lang.Math.round;


public abstract class FormatPricesForDisplay {

    // method to get the total price formatted with the euro symbol for display
    public String getFormattedTotalPrice(ArrayList<String> stringPrices)
    {
        ArrayList<Double> doublePrices = getPricesAsDoubles(stringPrices);
        return EURO_SYMBOL + getTotalPrice(doublePrices);
    }

    // method to get the breakdown prices formatted for display from an arraylist of prices (as strings)
    public String getFormattedBreakdownPrices(ArrayList<String> stringPrices)
    {
        ArrayList<Double> doublePrices = getPricesAsDoubles(stringPrices);
        return getFormattedPrices(doublePrices);
    }

    // method to get the total price from an arraylist of prices
    public double getTotalPrice(ArrayList<Double> prices)
    {
        double totalCost = 0.0;
        for (double price:prices)
        {
            totalCost+=price;
        }
        return roundToNearestCent(totalCost);
    }

    // method to get the prices as an arraylist of doubles from string
    public abstract ArrayList<Double> getPricesAsDoubles(ArrayList<String> stringPrices);

    // method to get product prices formatted into a single string, from an arraylist of doubles
    protected String getFormattedPrices(ArrayList<Double> prices)
    {
        String breakdownPrices = "";
        for (double price:prices)
        {
            breakdownPrices +=  EURO_SYMBOL + price + "\n";
        }
        return breakdownPrices;
    }

    // method to round a price in euro to the nearest cent
    protected double roundToNearestCent(double price)
    {
        price = round(price*100.0)/100.0;
        return price;
    }
}
