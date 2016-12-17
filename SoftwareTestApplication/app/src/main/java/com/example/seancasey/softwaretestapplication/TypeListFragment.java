package com.example.seancasey.softwaretestapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                createList();
                getPriceList();

                linker.replaceFragments(MyValues.LOAD_DISPLAY_FRAGMENT);
            }
        });

        SuperValuAsyncTask superValuAsyncTask = new SuperValuAsyncTask();

        return myInflatedView;
    }

    public ArrayList<String> getPricesInputted(ArrayList<String> itemsToSearchFor)
    {
        ArrayList<String> prices = new ArrayList<>();
        TescoAsyncTask tescoAsyncTask = new TescoAsyncTask();
        try
        {
            prices = tescoAsyncTask.execute(itemsToSearchFor).get();
        }
        catch(InterruptedException ex1)
        {
            ex1.printStackTrace();
        }
        catch (ExecutionException ex2)
        {
            ex2.printStackTrace();
        }
        return prices;
    }

    public void getPriceList()
    {
        ArrayList<String> prices = getPricesInputted(linker.getProductNames());
        linker.setProductPrices(prices);
    }

    public void createList()
    {
        shopList = editText.getText().toString();
        ArrayList<String> itemsToSearchFor = new ArrayList<String>(Arrays.asList(shopList.split("[\\r\\n]+")));
        linker.setProductNames(itemsToSearchFor); //TODO error checking fix later

    }




}
