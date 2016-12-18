package com.example.seancasey.softwaretestapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seancasey on 18/12/2016.
 */
public class FormatPricesForDisplayTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void roundToNearestCent() throws Exception {
        double price = 4.41312;
        assertEquals("The answer should be 4.41", 4.41, new FormatTescoPricesForDisplay().roundToNearestCent(price));
    }

}