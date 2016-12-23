package com.example.comp41670.COINPARE;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.EURO_SYMBOL;
import static org.junit.Assert.*;

/**
 * Created by seancasey on 22/12/2016.
 */
public class FormatSuperValuPricesForDisplayTest {

    ArrayList<String> stringPricesNormal;
    ArrayList<String> stringPricesAllZero;
    ArrayList<String> stringPricesNegative;
    ArrayList<Double> expectedDoublePricesNormal;
    ArrayList<Double> expectedDoublePricesAllZero;
    ArrayList<Double> expectedDoublePricesNegative;

    @Before
    public void setUp() throws Exception {

        stringPricesNormal = new ArrayList<>();
        stringPricesNormal.add("1.0");
        stringPricesNormal.add("1.5");
        stringPricesNormal.add("0.25");

        stringPricesAllZero = new ArrayList<>();
        stringPricesAllZero.add("0.0");
        stringPricesAllZero.add("0.0");
        stringPricesAllZero.add("0.0");

        stringPricesNegative = new ArrayList<>();
        stringPricesNegative.add("-1.21");
        stringPricesNegative.add("-11.3");
        stringPricesNegative.add("-0.24");

        expectedDoublePricesNormal = new ArrayList<>();
        expectedDoublePricesNormal.add(1.0);
        expectedDoublePricesNormal.add(1.5);
        expectedDoublePricesNormal.add(0.25);

        expectedDoublePricesAllZero = new ArrayList<>();
        expectedDoublePricesAllZero.add(0.0);
        expectedDoublePricesAllZero.add(0.0);
        expectedDoublePricesAllZero.add(0.0);

        expectedDoublePricesNegative = new ArrayList<>();
        expectedDoublePricesNegative.add(-1.21);
        expectedDoublePricesNegative.add(-11.3);
        expectedDoublePricesNegative.add(-0.24);

    }

    //getPricesAsDoubles test cases
    @Test
    public void getPricesAsDoublesNormalTest() throws Exception {
        assertEquals("Expect the list of prices to be returned as doubles", expectedDoublePricesNormal, new FormatSuperValuPricesForDisplay().getPricesAsDoubles(stringPricesNormal));
    }

    @Test
    public void getPricesAsDoublesAllZeroTest() throws Exception {
        assertEquals("Expect the actual list to contain three 0.0\'s", expectedDoublePricesAllZero, new FormatSuperValuPricesForDisplay().getPricesAsDoubles(stringPricesAllZero));
    }

    @Test
    public void getPricesAsDoublesNegativeTest() throws Exception {
        assertEquals("Expect the list of negative prices multiplied by exchange rate to be returned as doubles", expectedDoublePricesNegative, new FormatSuperValuPricesForDisplay().getPricesAsDoubles(stringPricesNegative));
    }

}