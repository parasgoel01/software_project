package com.example.seancasey.softwaretestapplication;

/**
 * Created by seancasey on 19/12/2016.
 */

public class RetrieveTescoPriceList extends RetrieveShopPriceList {
    public ShopProductPrice getShopProductPrice(){
        return new TescoProductPrice();
    }

}
