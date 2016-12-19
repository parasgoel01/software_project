package com.example.seancasey.softwaretestapplication;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.seancasey.softwaretestapplication.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

/**
 * Created by seancasey on 19/12/2016.
 */
public class RetrieveTescoPriceListTest {

    @Test
    public void productPricesNormalListTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        itemsToSearchFor.add("milk");
        itemsToSearchFor.add("watermelons");
        ArrayList<String> actualPrices = new RetrieveTescoPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add("0.9");
        expectedPrices.add("1.0");
        expectedPrices.add("0.5");
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

    @Test
    public void productPricesOneItemListTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        ArrayList<String> actualPrices = new RetrieveTescoPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add("0.9");
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

    @Test
    public void productPricesListWithInvalidItemTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        itemsToSearchFor.add("milk");
        itemsToSearchFor.add("watermelons");
        itemsToSearchFor.add("Concert Tickets");
        ArrayList<String> actualPrices = new RetrieveTescoPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add("0.9");
        expectedPrices.add("1.0");
        expectedPrices.add("0.5");
        expectedPrices.add(NO_PRICE_FOUND);
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

    @Test
    public void productPricesEmptyListTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        ArrayList<String> actualPrices = new RetrieveTescoPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

    @Test
    public void productPricesListWithAllInvalidItemsTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("12345");
        itemsToSearchFor.add("67890");
        itemsToSearchFor.add("24680");
        ArrayList<String> actualPrices = new RetrieveTescoPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add(NO_PRICE_FOUND);
        expectedPrices.add(NO_PRICE_FOUND);
        expectedPrices.add(NO_PRICE_FOUND);
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

}