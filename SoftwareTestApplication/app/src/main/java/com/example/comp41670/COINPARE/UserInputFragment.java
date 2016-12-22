package com.example.comp41670.COINPARE;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.comp41670.COINPARE.MyValues.LOAD_DISPLAY_FRAGMENT;
import static com.example.comp41670.COINPARE.MyValues.NO_PRICE_FOUND;

public class UserInputFragment extends Fragment {

    private View myInflatedView;
    private Linker linker;

    private EditText editShopList;
    private Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myInflatedView = inflater.inflate(R.layout.fragment_userinput, container, false);
        linker = (Linker)getActivity();
        submitButton = (Button) myInflatedView.findViewById(R.id.submitButton);
        editShopList = (EditText) myInflatedView.findViewById(R.id.editShopList);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shopListString = editShopList.getText().toString();
                if (shopListString.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), "No product entered", Toast.LENGTH_SHORT).show();
                    return;
                }
                ArrayList<String> itemsToSearchFor = createList(shopListString);

                ArrayList<String> tescoPrices = new RetrieveTescoPriceList().productPrices(itemsToSearchFor);

                if (tescoPrices.contains(NO_PRICE_FOUND))
                {
                    String wrongItem = findInvalidItem(itemsToSearchFor, tescoPrices);
                    Toast.makeText(getActivity(), "Invalid product: " + wrongItem, Toast.LENGTH_LONG).show();
                    return;
                }

                ArrayList<String> superValuPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);
                if (superValuPrices.contains(NO_PRICE_FOUND))
                {
                    String wrongItem = findInvalidItem(itemsToSearchFor, superValuPrices);
                    Toast.makeText(getActivity(), "Invalid product: " + wrongItem, Toast.LENGTH_LONG).show();

                    return;
                }


                setValuesForLinker(itemsToSearchFor, tescoPrices, superValuPrices);
                linker.replaceFragments(LOAD_DISPLAY_FRAGMENT);

            }
        });

        return myInflatedView;
    }

    private void setValuesForLinker(ArrayList<String> itemsToSearchFor, ArrayList<String> tescoPrices, ArrayList<String> superValuPrices) {
        linker.setProductNames(itemsToSearchFor);
        linker.setTescoProductPrices(tescoPrices);
        linker.setSuperValuProductPrices(superValuPrices);
    }

    public ArrayList<String> createList(String shopList)
    {
        return new ArrayList<String>(Arrays.asList(shopList.split("[\\r\\n]+")));
    }

    public String findInvalidItem(ArrayList<String> itemsToSearchFor, ArrayList<String> productPrices)
    {
        int wrongIndex = productPrices.indexOf(NO_PRICE_FOUND);
        return itemsToSearchFor.get(wrongIndex);
    }

}
