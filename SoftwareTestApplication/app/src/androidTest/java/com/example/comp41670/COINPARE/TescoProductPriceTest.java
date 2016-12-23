package com.example.comp41670.COINPARE;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.NO_PRICE_FOUND;
import static org.junit.Assert.*;

public class TescoProductPriceTest {

    String itemWithSpace;
    String itemWithNoSpace;
    String space;
    String itemWithMoreThanOneSpace;
    String emptyString;

    String expectedItemWithSpace;
    String expectedItemWithNoSpace;
    String expectedSpace;
    String expectedItemWithMoreThanOneSpace;
    String expectedEmptyString;


    @Before
    public void setUp() throws Exception {
        itemWithSpace = "ice cream";
        itemWithNoSpace = "bread";
        space = " ";
        itemWithMoreThanOneSpace = "chocolate ice cream";
        emptyString = "";

        expectedItemWithSpace = "ice+cream";
        expectedItemWithNoSpace = "bread";
        expectedSpace = "+";
        expectedItemWithMoreThanOneSpace = "chocolate+ice+cream";
        expectedEmptyString = "";


    }

    //getFixedString test cases
    @Test
    public void getFixedStringItemWithSpaceTest() throws Exception {
        assertEquals("Expect the space in the string to be replaced with +", expectedItemWithSpace, new TescoProductPrice().fixString(itemWithSpace));
    }

    @Test
    public void getFixedStringSpaceTest() throws Exception {
        assertEquals("Expect to replace space with +", expectedSpace, new TescoProductPrice().fixString(space));
    }

    @Test
    public void getFixedStringNoSpaceTest() throws Exception {
        assertEquals("Expect string to be unchanged when it has no space", expectedItemWithNoSpace, new TescoProductPrice().fixString(itemWithNoSpace));
    }

    @Test
    public void getFixedStringMoreThanOneSpaceTest() throws Exception {
        assertEquals("Expect to replace each space with +", expectedItemWithMoreThanOneSpace, new TescoProductPrice().fixString(itemWithMoreThanOneSpace));
    }

    @Test
    public void getFixedStringEmptyStringTest() throws Exception {
        assertEquals("Expect empty string to stay the same", expectedEmptyString, new TescoProductPrice().fixString(emptyString));
    }
}