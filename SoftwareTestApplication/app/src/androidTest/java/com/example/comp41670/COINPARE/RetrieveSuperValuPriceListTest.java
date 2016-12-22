package com.example.comp41670.COINPARE;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.NO_PRICE_FOUND;
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
    public void productPricesListWithInvalidItemTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        itemsToSearchFor.add("milk");
        itemsToSearchFor.add("eggs");
        itemsToSearchFor.add("lectures");
        ArrayList<String> actualPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add("0.79");
        expectedPrices.add("1.18");
        expectedPrices.add("0.55");
        expectedPrices.add(NO_PRICE_FOUND);
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

    @Test
    public void productPricesListWithAllInvalidItemsTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("12345");
        itemsToSearchFor.add("67890");
        ArrayList<String> actualPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add(NO_PRICE_FOUND);
        expectedPrices.add(NO_PRICE_FOUND);
        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

    @Test
    public void productPricesLongListTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        itemsToSearchFor.add("milk");
        itemsToSearchFor.add("watermelons");
        itemsToSearchFor.add("coke");
        itemsToSearchFor.add("apples");
        itemsToSearchFor.add("bananas");
        itemsToSearchFor.add("pepsi");
        itemsToSearchFor.add("sprite");
        itemsToSearchFor.add("strawberry");
        itemsToSearchFor.add("mango");

        ArrayList<String> actualPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);
        ArrayList<String> expectedPrices = new ArrayList<>();
        expectedPrices.add("0.79");
        expectedPrices.add("1.18");
        expectedPrices.add("34.99");
        expectedPrices.add("1.45");
        expectedPrices.add("0.55");
        expectedPrices.add("0.65");
        expectedPrices.add("1.00");
        expectedPrices.add("2.15");
        expectedPrices.add("0.65");
        expectedPrices.add("3.59");

        assertEquals("Expect the list of prices to be equal", expectedPrices, actualPrices);
    }

}