package com.example.comp41670.COINPARE;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

public class UserInputFragmentTest {

    String testStringNormal;
    ArrayList<String> expectedListNormal;

    String testStringExtraNewLines;
    ArrayList<String> expectedListExtraNewLines;

    String testStringItemsWithSpaces;
    ArrayList<String> expectedListItemsWithSpaces;

    String testStringListWithNumbers;
    ArrayList<String> expectedListWithNumbers;

    ArrayList<String> listWithInvalidItem;
    ArrayList<String> listWithInvalidItemPrices;

    ArrayList<String> listWithMoreThanOneInvalidItem;
    ArrayList<String> listWithMoreThanOneInvalidItemPrices;

    ArrayList<String> listWithAllInvalidItems;
    ArrayList<String> listWithAllInvalidItemsPrices;

    ArrayList<String> listWithNumbersAsInvalidItems;
    ArrayList<String> listWithNumbersAsInvalidItemsPrices;

    @Before
    public void setUp() throws Exception {

        testStringNormal = "bread\nmilk\nwatermelon";
        expectedListNormal = new ArrayList<>();
        expectedListNormal.add("bread");
        expectedListNormal.add("milk");
        expectedListNormal.add("watermelon");

        testStringExtraNewLines = "bread\nmilk\n\n\nwatermelon\n\n";
        expectedListExtraNewLines = expectedListNormal;

        testStringItemsWithSpaces = "bread\nice cream\nchocolate ice cream";
        expectedListItemsWithSpaces = new ArrayList<>();
        expectedListItemsWithSpaces.add("bread");
        expectedListItemsWithSpaces.add("ice cream");
        expectedListItemsWithSpaces.add("chocolate ice cream");

        testStringListWithNumbers = "12345\n76845\nchocolate ice cream";
        expectedListWithNumbers = new ArrayList<>();
        expectedListWithNumbers.add("12345");
        expectedListWithNumbers.add("76845");
        expectedListWithNumbers.add("chocolate ice cream");

        listWithInvalidItem = new ArrayList<>();
        listWithInvalidItem.add("bread");
        listWithInvalidItem.add("milk");
        listWithInvalidItem.add("Concert Tickets");
        listWithInvalidItem.add("chocolate ice cream");
        listWithInvalidItemPrices = new ArrayList<>();
        listWithInvalidItemPrices.add("1.0");
        listWithInvalidItemPrices.add("1.19");
        listWithInvalidItemPrices.add(NO_PRICE_FOUND);
        listWithInvalidItemPrices.add("2.5");

        listWithMoreThanOneInvalidItem = listWithInvalidItem;
        listWithMoreThanOneInvalidItem.add("lecture notes");
        listWithMoreThanOneInvalidItemPrices = listWithInvalidItemPrices;
        listWithMoreThanOneInvalidItemPrices.add(NO_PRICE_FOUND);

        listWithAllInvalidItems = new ArrayList<>();
        listWithAllInvalidItems.add("Concert Tickets");
        listWithAllInvalidItems.add("software engineering");
        listWithAllInvalidItems.add("aeroplanes");
        listWithAllInvalidItemsPrices = new ArrayList<>();
        listWithAllInvalidItemsPrices.add(NO_PRICE_FOUND);
        listWithAllInvalidItemsPrices.add(NO_PRICE_FOUND);
        listWithAllInvalidItemsPrices.add(NO_PRICE_FOUND);

        listWithNumbersAsInvalidItems = new ArrayList<>();
        listWithNumbersAsInvalidItems.add("bread");
        listWithNumbersAsInvalidItems.add("12345");
        listWithNumbersAsInvalidItems.add("54321");
        listWithNumbersAsInvalidItemsPrices = new ArrayList<>();
        listWithNumbersAsInvalidItemsPrices.add("0.79");
        listWithNumbersAsInvalidItemsPrices.add(NO_PRICE_FOUND);
        listWithNumbersAsInvalidItemsPrices.add(NO_PRICE_FOUND);
    }

    //createList test cases
    @Test
    public void createListNormalTest() throws Exception {
        assertEquals("Expect the string to be split into a list of 3 items", expectedListNormal, new UserInputFragment().createList(testStringNormal));
    }

    @Test
    public void createListExtraNewLinesTest() throws Exception {
        assertEquals("Expect the string to be split into a list of 3 items, despite extra new lines", expectedListExtraNewLines, new UserInputFragment().createList(testStringExtraNewLines));
    }

    @Test
    public void createListItemsWithSpacesTest() throws Exception {
        assertEquals("Expect the string to be split into a list of 3 items", expectedListItemsWithSpaces, new UserInputFragment().createList(testStringItemsWithSpaces));
    }

    @Test
    public void createListItemsWithNumbersTest() throws Exception {
        assertEquals("Expect the string to be split into a list of 3 items", expectedListWithNumbers, new UserInputFragment().createList(testStringListWithNumbers));
    }

    @Test
    public void findInvalidItemOneInvalidItemTest() throws Exception {
        assertEquals("Expect to find \"Concert Tickets\" as the invalid item", "Concert Tickets",new UserInputFragment().findInvalidItem(listWithInvalidItem, listWithInvalidItemPrices));
    }

    @Test
    public void findInvalidItemMoreThanOneInvalidItemTest() throws Exception {
        assertEquals("Expect \"Concert Tickets\" item to be the invalid item, as it is the 1st invalid item", "Concert Tickets",new UserInputFragment().findInvalidItem(listWithMoreThanOneInvalidItem, listWithMoreThanOneInvalidItemPrices));
    }

    @Test
    public void findInvalidItemAllInvalidItemsTest() throws Exception {
        assertEquals("Expect \"Concert Tickets\" item to be the invalid item, as it is the 1st invalid item", "Concert Tickets",new UserInputFragment().findInvalidItem(listWithAllInvalidItems, listWithAllInvalidItemsPrices));
    }

    @Test
    public void findInvalidItemNumbersAsInvalidItemsTest() throws Exception {
        assertEquals("Expect the 1st number in list \"12345\" item to be the invalid item, as it is the 1st invalid item", "12345",new UserInputFragment().findInvalidItem(listWithNumbersAsInvalidItems, listWithNumbersAsInvalidItemsPrices));
    }

}