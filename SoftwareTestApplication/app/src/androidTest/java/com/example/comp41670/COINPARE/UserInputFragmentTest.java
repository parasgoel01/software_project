package com.example.comp41670.COINPARE;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

/**
 * Created by seancasey on 19/12/2016.
 */
public class UserInputFragmentTest {
    @Test
    public void createListNormalTest() throws Exception {
        String testString = "bread\nmilk\nwatermelon";
        ArrayList<String> actualList = new UserInputFragment().createList(testString);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("bread");
        expectedList.add("milk");
        expectedList.add("watermelon");
        assertEquals("Expect the two lists to be equal", expectedList, actualList);

    }

    @Test
    public void createListExtraNewLinesTest() throws Exception {
        String testString = "bread\nmilk\n\n\nwatermelon\n\n";
        ArrayList<String> actualList = new UserInputFragment().createList(testString);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("bread");
        expectedList.add("milk");
        expectedList.add("watermelon");
        assertEquals("Expect the two lists to be equal", expectedList, actualList);
    }

    @Test
    public void createListItemsWithSpacesTest() throws Exception {
        String testString = "bread\nice cream\nchocolate ice cream";
        ArrayList<String> actualList = new UserInputFragment().createList(testString);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("bread");
        expectedList.add("ice cream");
        expectedList.add("chocolate ice cream");
        assertEquals("Expect the two lists to be equal", expectedList, actualList);
    }

    @Test
    public void createListItemsWithNumbersTest() throws Exception {
        String testString = "12345\n76845\nchocolate ice cream";
        ArrayList<String> actualList = new UserInputFragment().createList(testString);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("12345");
        expectedList.add("76845");
        expectedList.add("chocolate ice cream");
        assertEquals("Expect the two lists to be equal", expectedList, actualList);
    }

    @Test
    public void findInvalidItemNormalTest() throws Exception {
        ArrayList<String> itemsToSearchFor = new ArrayList<>();
        itemsToSearchFor.add("bread");
        itemsToSearchFor.add("milk");
        itemsToSearchFor.add("Concert Tickets");
        itemsToSearchFor.add("eggs");
        ArrayList<String> productPrices = new ArrayList<>();
        productPrices.add("1.0");
        productPrices.add("0.5");
        productPrices.add(NO_PRICE_FOUND);
        productPrices.add("0.55");

        assertEquals("Expect \"Concert Tickets\" item to be the wrong one", "Concert Tickets", new UserInputFragment().findInvalidItem(itemsToSearchFor, productPrices));
    }

}