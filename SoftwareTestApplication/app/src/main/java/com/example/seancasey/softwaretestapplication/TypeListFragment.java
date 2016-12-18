package com.example.seancasey.softwaretestapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.seancasey.softwaretestapplication.MyValues.LOAD_DISPLAY_FRAGMENT;

public class TypeListFragment extends Fragment {

    private View myInflatedView;
    private Linker linker;

    private EditText editText;
    private Button button2;
    private String shopList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myInflatedView = inflater.inflate(R.layout.fragment_typelist, container, false);
        linker = (Linker)getActivity();
        button2 = (Button) myInflatedView.findViewById(R.id.button2);
        editText = (EditText) myInflatedView.findViewById(R.id.editText);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> itemsToSearchFor = createList();
                //ArrayList<String> tescoPrices = getTescoPrices(itemsToSearchFor);
                //ArrayList<String> superValuPrices = getSuperValuPrices(itemsToSearchFor);
                ArrayList<String> tescoPrices = new TescoGetPricesInputted().getShopPrices(itemsToSearchFor);
                ArrayList<String> superValuPrices = new SuperValuGetPricesInputted().getShopPrices(itemsToSearchFor);
                linker.setProductNames(itemsToSearchFor);
                linker.setTescoProductPrices(tescoPrices);
                linker.setSuperValuProductPrices(superValuPrices);
                //getPriceList();

                linker.replaceFragments(LOAD_DISPLAY_FRAGMENT);
            }
        });

        SuperValuProductPrice superValuAsyncTask = new SuperValuProductPrice();

        return myInflatedView;
    }

    /*public ArrayList<String> getTescoPrices(ArrayList<String> itemsToSearchFor)
    {
        TescoGetPricesInputted tescoGetPricesInputted = new TescoGetPricesInputted(); //ASK (static?)
        return tescoGetPricesInputted.getPricesInputted(itemsToSearchFor);
    }
    */
    /*
    public ArrayList<String> getSuperValuPrices(ArrayList<String> itemsToSearchFor)
    {
        SuperValuGetPricesInputted superValuGetPricesInputted = new SuperValuGetPricesInputted(); //ASK (static?)
        return superValuGetPricesInputted.getPricesInputted(itemsToSearchFor);
    }
    */

    /*
    public void getPriceList()
    {
        ArrayList<String> prices = getTescoPrices(linker.getProductNames());
        linker.setTescoProductPrices(prices);
    }
    */
    public ArrayList<String> createList()
    {
        shopList = editText.getText().toString();
        ArrayList<String> itemsToSearchFor = new ArrayList<String>(Arrays.asList(shopList.split("[\\r\\n]+")));
        linker.setProductNames(itemsToSearchFor); //TODO error checking fix later
        return itemsToSearchFor;

    }




}
