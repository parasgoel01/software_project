package com.example.seancasey.softwaretestapplication;


public final class MyValues {
    public static final int LOAD_TYPE_LIST_FRAGMENT = 0;
    public static final int LOAD_DISPLAY_FRAGMENT = 1;

    public static final int CURRENT_TYPE_LIST_FRAGMENT = 0;
    public static final int CURRENT_DISPLAY_FRAGMENT = 1;

    public static final double EXCHANGE_RATE = 1.19; //correct on 17 Decemember 2016

    public static final int MAX_CHARS = 10; //max characters per product name in price breakdown

    public static final String TESCO_SUBSCRIPTION_KEY = "Ocp-Apim-Subscription-Key";
    public static final String SUBSCRIPTION_KEY_VALUE = "3e3f4b70e52743f19ed51bed179a212c";
    public static final String TESCO_URL_START = "https://dev.tescolabs.com/grocery/products/?query=";
    public static final String TESCO_URL_END = "&offset=0&limit=1";


    public static final String SUPERVALU_URL_START = "https://shop.supervalu.ie/shopping/search/allaisles?q=";
    public static final String SUPERVALU_PRICE_REGEX = ".*?(\\d+(\\.\\d+)*).*";
    public static final String EURO_SYMBOL = "€";
}
