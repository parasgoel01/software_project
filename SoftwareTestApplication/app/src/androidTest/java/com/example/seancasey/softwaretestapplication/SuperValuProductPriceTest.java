package com.example.seancasey.softwaretestapplication;

import org.junit.Test;

import static com.example.seancasey.softwaretestapplication.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

/**
 * Created by seancasey on 19/12/2016.
 */
public class SuperValuProductPriceTest {
    @Test
    public void getPricesMilkTest() throws Exception {
        assertTrue("Expected cost of milk = 1.18", new SuperValuProductPrice().getIndividualProductPrice("milk").equals("1.18"));
    }

    @Test
    public void getPricesBreadTest() throws Exception {
        assertTrue("Expected cost of bread = 0.79", new SuperValuProductPrice().getIndividualProductPrice("bread").equals("0.79"));

    }

    @Test
    public void getPricesItemWithSpaceTest() throws Exception {
        assertTrue("Expected cost of ice cream = 2.63", new SuperValuProductPrice().getIndividualProductPrice("ice cream").equals("2.63"));

    }

    @Test
    public void getPricesInvalidItemTest() throws Exception {
        //assertTrue("Expect to get error", new SuperValuProductPrice().getIndividualProductPrice("Concert Tickets").equals(NO_PRICE_FOUND));
    }

    @Test
    public void getPricesEmptyStringTest() throws Exception {
        //assertTrue("Expect to get error", new SuperValuProductPrice().getIndividualProductPrice(" ").equals(NO_PRICE_FOUND));
        // ASK

    }
}