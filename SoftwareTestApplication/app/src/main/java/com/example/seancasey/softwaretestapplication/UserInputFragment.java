package com.example.seancasey.softwaretestapplication;

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

import static com.example.seancasey.softwaretestapplication.MyValues.LOAD_DISPLAY_FRAGMENT;

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
                if (shopListString.equals(""))
                {
                    Toast.makeText(getActivity(), "No product entered", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Fetching prices. Please wait, this may take a while...", Toast.LENGTH_LONG).show(); //ASK
                    ArrayList<String> itemsToSearchFor = createList(shopListString);

                    ArrayList<String> tescoPrices = new RetrieveTescoPriceList().productPrices(itemsToSearchFor);
                    ArrayList<String> superValuPrices = new RetrieveSuperValuPriceList().productPrices(itemsToSearchFor);

                    setValuesForLinker(itemsToSearchFor, tescoPrices, superValuPrices);
                    linker.replaceFragments(LOAD_DISPLAY_FRAGMENT);
                }
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
        ArrayList<String> itemsToSearchFor = new ArrayList<String>(Arrays.asList(shopList.split("[\\r\\n]+")));
        linker.setProductNames(itemsToSearchFor); //TODO error checking fix later
        return itemsToSearchFor;
    }




}
