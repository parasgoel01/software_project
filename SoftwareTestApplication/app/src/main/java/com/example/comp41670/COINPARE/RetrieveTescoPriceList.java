package com.example.comp41670.COINPARE;

public class RetrieveTescoPriceList extends RetrieveShopPriceList {

    public ShopProductPrice getShopProductPrice()
    {
        return new TescoProductPrice();
    }

}
