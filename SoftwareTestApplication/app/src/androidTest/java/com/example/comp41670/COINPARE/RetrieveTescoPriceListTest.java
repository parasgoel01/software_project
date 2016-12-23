package com.example.comp41670.COINPARE;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

public class RetrieveTescoPriceListTest {

    ArrayList<String> productNamesLongList;
    ArrayList<String> expectedPriceLongList;

    ArrayList<String> productNamesOneItemList;
    ArrayList<String> expectedPriceOneItemList;

    ArrayList<String> productNamesEmptyList;
    ArrayList<String> expectedPriceEmptyList;

    ArrayList<String> productNamesSpaceList;
    ArrayList<String> expectedPriceSpaceList;

    ArrayList<String> productNamesListWithInvalidItem;
    ArrayList<String> expectedPriceListWithInvalidItem;

    ArrayList<String> productNamesListOfNumbers;
    ArrayList<String> expectedPriceListOfNumbers;

    @Before
    public void setUp() throws Exception {
        productNamesLongList = new ArrayList<>();
        productNamesLongList.add("milk");
        productNamesLongList.add("ice cream");
        productNamesLongList.add("strawberries");
        productNamesLongList.add("pepsi");
        productNamesLongList.add("chocolate ice cream");
        productNamesLongList.add("raspberries");
        productNamesLongList.add("bananas");
        productNamesLongList.add("celebrations");
        productNamesLongList.add("Corn Flakes");

        expectedPriceLongList = new ArrayList<>();
        expectedPriceLongList.add("1.0");
        expectedPriceLongList.add("2.0");
        expectedPriceLongList.add("2.0");
        expectedPriceLongList.add("1.0");
        expectedPriceLongList.add("1.5");
        expectedPriceLongList.add("2.0");
        expectedPriceLongList.add("0.72");
        expectedPriceLongList.add("5.0");
        expectedPriceLongList.add("2.49");

        productNamesEmptyList = new ArrayList<>();
        expectedPriceEmptyList = new ArrayList<>();

        productNamesOneItemList = new ArrayList<>();
        productNamesOneItemList.add("celebrations");
        expectedPriceOneItemList = new ArrayList<>();
        expectedPriceOneItemList.add("5.0");

        productNamesSpaceList = new ArrayList<>();
        productNamesSpaceList.add(" ");
        expectedPriceSpaceList = new ArrayList<>();
        expectedPriceSpaceList.add(NO_PRICE_FOUND);

        productNamesListWithInvalidItem = productNamesLongList;
        productNamesListWithInvalidItem.add("Concert Tickets");
        expectedPriceListWithInvalidItem = expectedPriceLongList;
        expectedPriceListWithInvalidItem.add(NO_PRICE_FOUND);

        productNamesListOfNumbers = new ArrayList<>();
        productNamesListOfNumbers.add("12345");
        productNamesListOfNumbers.add("67890");
        productNamesListOfNumbers.add("24680");

        expectedPriceListOfNumbers = new ArrayList<>();
        expectedPriceListOfNumbers.add(NO_PRICE_FOUND);
        expectedPriceListOfNumbers.add(NO_PRICE_FOUND);
        expectedPriceListOfNumbers.add(NO_PRICE_FOUND);
    }

    //productPrices test cases
    @Test
    public void productPricesLongListTest() throws Exception {
        assertEquals("Expect a list of prices for each item", expectedPriceLongList, new RetrieveTescoPriceList().productPrices(productNamesLongList));
    }

    @Test
    public void productPricesOneItemListTest() throws Exception {
        assertEquals("Expect price of celebrations to be £5", expectedPriceOneItemList,new RetrieveTescoPriceList().productPrices(productNamesOneItemList));
    }

    @Test
    public void productPricesListWithInvalidItemTest() throws Exception {
        assertEquals("Expect a list of prices for each valid item, and PRICE_NOT_FOUND for invalid item", expectedPriceListWithInvalidItem, new RetrieveTescoPriceList().productPrices(productNamesListWithInvalidItem));
    }

    @Test
    public void productPricesEmptyListTest() throws Exception {
        assertEquals("Expect an empty list", expectedPriceEmptyList, new RetrieveTescoPriceList().productPrices(productNamesEmptyList));
    }

    @Test
    public void productPricesListOfNumbersTest() throws Exception {
        assertEquals("Expect NO_PRICE_FOUND for each item", expectedPriceListOfNumbers, new RetrieveTescoPriceList().productPrices(productNamesListOfNumbers));
    }

}