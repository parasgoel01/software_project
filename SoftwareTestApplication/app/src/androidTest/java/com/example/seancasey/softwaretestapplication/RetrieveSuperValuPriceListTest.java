package com.example.seancasey.softwaretestapplication;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.seancasey.softwaretestapplication.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

/**
 * Created by seancasey on 19/12/2016.
 */
public class RetrieveSuperValuPriceListTest {

    @Test
    public void productPricesNormalListTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        itemsToSearchFor.add("milk");
        itemsToSearchFor.add("eggs");
        ArrayList<String> actualPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add("0.79");
        expectedPrices.add("1.18");
        expectedPrices.add("0.55");
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

    @Test
    public void productPricesOneItemListTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        ArrayList<String> actualPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add("0.79");
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

    @Test
    public void productPricesEmptyListTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        ArrayList<String> actualPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

}