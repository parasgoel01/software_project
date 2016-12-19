package com.example.seancasey.softwaretestapplication;


import android.util.Log;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static com.example.seancasey.softwaretestapplication.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

/**
 * Created by seancasey on 18/12/2016.
 */
public class TescoProductPriceTest {
    @Test
    public void getPricesMilkTest() throws Exception {
        assertTrue("Expected cost of milk = 1.0", new TescoProductPrice().getIndividualProductPrice("milk").equals("1.0"));
    }

    @Test
    public void getPricesBreadTest() throws Exception {
        assertTrue("Expected cost of bread = 0.9", new TescoProductPrice().getIndividualProductPrice("bread").equals("0.9"));

    }

    @Test
    public void getPricesItemWithSpaceTest() throws Exception {
        assertTrue("Expected cost of ice cream = 2.0", new TescoProductPrice().getIndividualProductPrice("ice cream").equals("2.0"));

    }

    @Test
    public void getPricesInvalidItemTest() throws Exception {
        assertTrue("Expect to get error", new TescoProductPrice().getIndividualProductPrice("Concert Tickets").equals(NO_PRICE_FOUND));
    }

    @Test
    public void getPricesNumberTest() throws Exception {
        assertTrue("Expect to get error", new TescoProductPrice().getIndividualProductPrice("12345").equals(NO_PRICE_FOUND));

    }

    @Test
    public void getPricesEmptyStringTest() throws Exception {
        //assertTrue("Expect to get error", new TescoProductPrice().getIndividualProductPrice(" ").equals(NO_PRICE_FOUND));
        // ASK

    }

    @Test
    public void getFixedStringItemWithSpaceTest() throws Exception {
        assertTrue("Expect to replace space with +", new TescoProductPrice().fixString("ice cream").equals("ice+cream"));
    }

    @Test
    public void getFixedStringSpaceTest() throws Exception {
        assertTrue("Expect to replace space with +", new TescoProductPrice().fixString(" ").equals("+"));
    }

    @Test
    public void getFixedStringNoSpaceTest() throws Exception {
        assertTrue("Expect string to be unchanged when it has no space", new TescoProductPrice().fixString("bread").equals("bread"));
    }

    @Test
    public void getFixedStringMoreThanOneSpaceTest() throws Exception {
        assertTrue("Expect to replace each space with +", new TescoProductPrice().fixString("chocolate ice cream").equals("chocolate+ice+cream"));
    }

    @Test
    public void getFixedStringEmptyStringTest() throws Exception {
        assertTrue("Expect empty string to stay the same", new TescoProductPrice().fixString("").equals(""));
    }

    @Test
    public void getFixedStringNullTest() throws Exception {
        assertTrue("Expect empty string to stay the same", new TescoProductPrice().fixString(null).equals(null));
    }





}