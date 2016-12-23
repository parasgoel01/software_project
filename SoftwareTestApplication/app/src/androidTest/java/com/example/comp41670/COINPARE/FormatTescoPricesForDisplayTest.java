package com.example.comp41670.COINPARE;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.EURO_SYMBOL;
import static org.junit.Assert.*;

public class FormatTescoPricesForDisplayTest {

    ArrayList<String> stringPricesNormal;
    ArrayList<String> stringPricesAllZero;
    ArrayList<String> stringPricesNegative;
    ArrayList<Double> expectedDoublePricesNormal;
    ArrayList<Double> expectedDoublePricesAllZero;
    ArrayList<Double> expectedDoublePricesNegative;

    String expectedPricesInEuroNormal;
    String expectedPricesInEuroAllZero;
    String expectedPricesInEuroNegative;

    String expectedTotalPriceNormal;
    String expectedTotalPricesNegative;
    String expectedTotalPricesAllZero;


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
        expectedDoublePricesNormal.add(1.19);
        expectedDoublePricesNormal.add(1.79);
        expectedDoublePricesNormal.add(0.3);

        expectedDoublePricesAllZero = new ArrayList<>();
        expectedDoublePricesAllZero.add(0.0);
        expectedDoublePricesAllZero.add(0.0);
        expectedDoublePricesAllZero.add(0.0);

        expectedDoublePricesNegative = new ArrayList<>();
        expectedDoublePricesNegative.add(-1.44);
        expectedDoublePricesNegative.add(-13.45);
        expectedDoublePricesNegative.add(-0.29);

        expectedPricesInEuroNormal = EURO_SYMBOL+"1.19"+"\n"+EURO_SYMBOL+"1.79\n"+EURO_SYMBOL+"0.3\n";
        expectedPricesInEuroAllZero = EURO_SYMBOL+"0.0\n"+EURO_SYMBOL+"0.0\n"+EURO_SYMBOL+"0.0\n";
        expectedPricesInEuroNegative = EURO_SYMBOL+"-1.44\n"+EURO_SYMBOL+"-13.45\n"+EURO_SYMBOL+"-0.29\n";

        expectedTotalPriceNormal = EURO_SYMBOL + "3.28";
        expectedTotalPricesNegative = EURO_SYMBOL + "-15.18";
        expectedTotalPricesAllZero = EURO_SYMBOL + "0.0";


    }

    //roundToNearestCent test cases
    @Test
    public void roundToNearestCentNormalRoundUpTest() throws Exception {
        assertEquals("Expect to round up to 4.45", 4.45, new FormatTescoPricesForDisplay().roundToNearestCent(4.446), 0);

    }

    @Test
    public void roundToNearestCentNormalRoundDownTest() throws Exception {
        assertEquals("Expect to round down to 3.36", 3.36, new FormatTescoPricesForDisplay().roundToNearestCent(3.363), 0);

    }

    @Test
    public void roundToNearestCentVerySmallNumberTest() throws Exception {
        assertEquals("Expect to round to 0", 0.0, new FormatTescoPricesForDisplay().roundToNearestCent(0.001), 0);

    }

    @Test
    public void roundToNearestCentVeryLargeNumberTest() throws Exception {
        assertEquals("Expect to round to 123456.78", 123456.78, new FormatTescoPricesForDisplay().roundToNearestCent(123456.784), 0);

    }

    @Test
    public void roundToNearestCentExecessiveDigitsTest() throws Exception {
        assertEquals("Expect to round to 12.46", 12.46, new FormatTescoPricesForDisplay().roundToNearestCent(12.45800120034), 0);

    }

    @Test
    public void roundToNearestCentNegativeNumberTest() throws Exception {
        assertEquals("Expect to round to -11.87", -11.87, new FormatTescoPricesForDisplay().roundToNearestCent(-11.869), 0);

    }

    //poundToEuro test cases
    @Test
    public void poundToEuroNormalTest() throws Exception {
        assertEquals("Expect to get €1.19", 1.19, new FormatTescoPricesForDisplay().poundToEuro(1.0), 0);

    }

    @Test
    public void poundToEuroNegativeNumberTest() throws Exception {
        assertEquals("Expect to get -€2.38", -2.38, new FormatTescoPricesForDisplay().poundToEuro(-2.0), 0);

    }

    @Test
    public void poundToEuroZeroTest() throws Exception {
        assertEquals("Expect to get zero", 0.0, new FormatTescoPricesForDisplay().poundToEuro(0.0), 0);

    }

    //getPricesAsDoubles test cases
    @Test
    public void getPricesAsDoublesNormalTest() throws Exception {
        assertEquals("Expect the list of prices multiplied by the exchange rate to be returned as doubles", expectedDoublePricesNormal, new FormatTescoPricesForDisplay().getPricesAsDoubles(stringPricesNormal));
    }

    @Test
    public void getPricesAsDoublesAllZeroTest() throws Exception {
        assertEquals("Expect the actual list to contain three 0.0\'s", expectedDoublePricesAllZero, new FormatTescoPricesForDisplay().getPricesAsDoubles(stringPricesAllZero));
    }

    @Test
    public void getPricesAsDoublesNegativeTest() throws Exception {
        assertEquals("Expect the list of negative prices multiplied by exchange rate to be returned as doubles", expectedDoublePricesNegative, new FormatTescoPricesForDisplay().getPricesAsDoubles(stringPricesNegative));
    }

    //getFormattedBreakdownPrices test cases
    @Test
    public void getFormattedBreakdownPricesNormalTest() throws Exception {
        assertEquals("Expect a list of prices in euro", expectedPricesInEuroNormal, new FormatTescoPricesForDisplay().getFormattedBreakdownPrices(stringPricesNormal));
    }

    @Test
    public void getFormattedBreakdownPricesAllZeroTest() throws Exception {
        assertEquals("Expect a list of prices in euro which are all zero", expectedPricesInEuroAllZero, new FormatTescoPricesForDisplay().getFormattedBreakdownPrices(stringPricesAllZero));
    }

    @Test
    public void getFormattedBreakdownPricesNegativeTest() throws Exception {
        assertEquals("Expect a list of prices in euro which are all negative", expectedPricesInEuroNegative, new FormatTescoPricesForDisplay().getFormattedBreakdownPrices(stringPricesNegative));
    }

    //getFormattedPrice test cases
    @Test
    public void getFormattedTotalPriceNormalTest() throws Exception {
        assertEquals("Expect total to be equal to 3.28", expectedTotalPriceNormal, new FormatTescoPricesForDisplay().getFormattedTotalPrice(stringPricesNormal));
    }

    @Test
    public void getFormattedTotalPriceAllNegativeTest() throws Exception {
        assertEquals("Expect total to be equal to -15.18", expectedTotalPricesNegative, new FormatTescoPricesForDisplay().getFormattedTotalPrice(stringPricesNegative));
    }

    @Test
    public void getFormattedTotalPriceAllZeroTest() throws Exception {
        assertEquals("Expect total to be equal to 0", expectedTotalPricesAllZero, new FormatTescoPricesForDisplay().getFormattedTotalPrice(stringPricesAllZero));
    }

}