package com.example.seancasey.softwaretestapplication;

import android.content.Context;

/**
 * Created by seancasey on 19/12/2016.
 */

public class RetrieveTescoPriceList extends RetrieveShopPriceList {

    public ShopProductPrice getShopProductPrice(){
        return new TescoProductPrice();
    }

}
