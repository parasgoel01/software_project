package com.example.seancasey.softwaretestapplication;

import android.content.Context;
import android.content.ContextWrapper;

/**
 * Created by seancasey on 19/12/2016.
 */

public class MyContextWrapper extends ContextWrapper {

    public MyContextWrapper(Context base) {
        //super(base);
        super(new MainActivity());
    }
}
