package com.example.comp41670.COINPARE;

public class RetrieveSuperValuPriceList extends RetrieveShopPriceList {
    public ShopProductPrice getShopProductPrice()
    {
        return new SuperValuProductPrice();
    }
}
