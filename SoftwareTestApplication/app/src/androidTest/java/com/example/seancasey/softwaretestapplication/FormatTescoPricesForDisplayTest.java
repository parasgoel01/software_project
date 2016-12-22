package com.example.seancasey.softwaretestapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seancasey on 19/12/2016.
 */
public class FormatTescoPricesForDisplayTest {
    @Test
    public void getPricesAsDoubles() throws Exception {

    }

    @Test
    public void getFormattedTotalPrice() throws Exception {

    }

    @Test
    public void getFormattedBreakdownPrices() throws Exception {

    }

    @Test
    public void getTotalPrice() throws Exception {

    }

    @Test
    public void getFormattedPrices() throws Exception {

    }


    // roundToNearestCent() test cases
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

    @Test
    public void poundToEuroNormalTest() throws Exception {
        assertEquals("Expect to round to €1.19", 1.19, new FormatTescoPricesForDisplay().poundToEuro(1.0), 0);

    }

    @Test
    public void poundToEuroNegativeNumberTest() throws Exception {
        assertEquals("Expect to round to -€2.38", 2.38, new FormatTescoPricesForDisplay().poundToEuro(2.0), 0);

    }

}