package com.example.comp41670.COINPARE;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by seancasey on 22/12/2016.
 */
public class DisplayFragmentTest {

    ArrayList<String> productNamesLongList;
    String expectedProductNamesLongListFormatted;

    ArrayList<String> productNamesOneItemList;
    String expectedProductNamesOneItemListFormatted;

    ArrayList<String> productNamesEmptyList;
    String expectedProductNamesEmptyListFormatted;

    ArrayList<String> productNamesSpaceList;
    String expectedProductNamesSpaceListFormatted;



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
        expectedProductNamesLongListFormatted = "milk\nice cream\nstrawberri\npepsi\nchocolate \nraspberrie\nbananas\ncelebratio\nCorn Flake\n";

        productNamesEmptyList = new ArrayList<>();
        expectedProductNamesEmptyListFormatted = "";

        productNamesOneItemList = new ArrayList<>();
        productNamesOneItemList.add("celebrations");
        expectedProductNamesOneItemListFormatted = "celebratio\n";

        productNamesSpaceList = new ArrayList<>();
        productNamesSpaceList.add(" ");
        expectedProductNamesSpaceListFormatted = " \n";
    }

    @Test
    public void getFormattedProductNamesLongListTest() throws Exception {
        assertEquals("Expect that no characters in the list exceed 10 chars", expectedProductNamesLongListFormatted, new DisplayFragment().getFormattedProductNames(productNamesLongList));

    }

    @Test
    public void getFormattedProductNamesEmptyListTest() throws Exception {
        assertEquals("Expect an empty list", expectedProductNamesEmptyListFormatted, new DisplayFragment().getFormattedProductNames(productNamesEmptyList));

    }

    @Test
    public void getFormattedProductNamesOneItemListTest() throws Exception {
        assertEquals("Expect one item in list, cutoff at 10 chars", expectedProductNamesOneItemListFormatted, new DisplayFragment().getFormattedProductNames(productNamesOneItemList));

    }

    @Test
    public void getFormattedProductNamesSpaceListTest() throws Exception {
        assertEquals("Expect a space and new line", expectedProductNamesSpaceListFormatted, new DisplayFragment().getFormattedProductNames(productNamesSpaceList));

    }

}