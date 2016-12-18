package com.example.seancasey.softwaretestapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seancasey on 18/12/2016.
 */
public class TescoProductPriceTest {
    @Test
    public void getPricesMilkTest() throws Exception {
        assertEquals("Expected cost of milk = 1.0", "1.0", new TescoProductPrice().getPrices("milk"));

    }

    @Test
    public void getPricesBreadTest() throws Exception {
        assertEquals("Expected cost of bread = 0.9", "0.9", new TescoProductPrice().getPrices("bread"));

    }

}