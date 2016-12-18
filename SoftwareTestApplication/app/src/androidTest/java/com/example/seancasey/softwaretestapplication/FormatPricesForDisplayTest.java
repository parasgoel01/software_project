package com.example.seancasey.softwaretestapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seancasey on 18/12/2016.
 */
public class FormatPricesForDisplayTest {

    @Test
    public void roundToNearestCentTesco() throws Exception {
        double price = 4.41312;
        assertEquals("The answer should be 4.41", 4.41, new FormatSuperValuPricesForDisplay().roundToNearestCent(price), 0);
    }

    @Test
    public void roundToNearestCentSuperValu() throws Exception {
        double price = 4.41312;
        assertEquals("The answer should be 4.41", 4.41, new FormatSuperValuPricesForDisplay().roundToNearestCent(price), 0);
    }

    @Test
    public void roundToNearestCentRoundUp() throws Exception {
        double price = 4.4158;
        assertEquals("The answer should be 4.42", 4.42, new FormatTescoPricesForDisplay().roundToNearestCent(price), 0);
    }

}