package com.example.comp41670.COINPARE;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.comp41670.COINPARE.MyValues.MAX_CHARS;

public class DisplayFragment extends Fragment {

    private View myInflatedView;
    private Linker linker;

    private TextView tescoPriceView;
    private TextView superValuPriceView;
    private TableLayout breakdownTableLayout;
    private Button breakdownButton;
    private TextView productNameView;
    private TextView tescoBreakdownView;
    private TextView superValuBreakdownView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myInflatedView = inflater.inflate(R.layout.fragment_display, container, false);
        linker = (Linker)getActivity();

        tescoPriceView = (TextView) myInflatedView.findViewById(R.id.tescoPriceView);
        superValuPriceView = (TextView) myInflatedView.findViewById(R.id.superValuPriceView);
        breakdownTableLayout = (TableLayout) myInflatedView.findViewById(R.id.breakdownTableLayout);
        breakdownButton = (Button) myInflatedView.findViewById(R.id.breakdownButton);
        productNameView = (TextView) myInflatedView.findViewById(R.id.productNameView);
        tescoBreakdownView = (TextView)myInflatedView.findViewById(R.id.tescoBreakdownView);
        superValuBreakdownView = (TextView)myInflatedView.findViewById(R.id.superValuBreakdownView);

        breakdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePriceBreakdown();
            }
        });

        displayProductDetails(linker.getProductNames());

        return myInflatedView;
    }

    private void displayProductDetails(ArrayList<String> productNames) {
        FormatTescoPricesForDisplay formatTescoPricesForDisplay = new FormatTescoPricesForDisplay();
        FormatSuperValuPricesForDisplay formatSuperValuPricesForDisplay = new FormatSuperValuPricesForDisplay();

        displayTotalPrices(formatTescoPricesForDisplay, formatSuperValuPricesForDisplay);
        displayBreakdownProducts(productNames);
        displayBreakdownPrices(formatTescoPricesForDisplay, formatSuperValuPricesForDisplay);
    }

    // display individual product names from SuperValu and Tesco
    private void displayBreakdownProducts(ArrayList<String> productNames) {
        productNameView.setText(getFormattedProductNames(productNames));
    }

    // display individual product prices from SuperValu and Tesco
    private void displayBreakdownPrices(FormatTescoPricesForDisplay formatTescoPricesForDisplay, FormatSuperValuPricesForDisplay formatSuperValuPricesForDisplay) {
        tescoBreakdownView.setText(formatTescoPricesForDisplay.getFormattedBreakdownPrices(linker.getTescoProductPrices()));
        superValuBreakdownView.setText(formatSuperValuPricesForDisplay.getFormattedBreakdownPrices(linker.getSuperValuProductPrices()));
    }

    // display the sum of price lists from SuperValu and Tesco
    private void displayTotalPrices(FormatTescoPricesForDisplay formatTescoPricesForDisplay, FormatSuperValuPricesForDisplay formatSuperValuPricesForDisplay) {
        tescoPriceView.setText(formatTescoPricesForDisplay.getFormattedTotalPrice(linker.getTescoProductPrices()));
        superValuPriceView.setText(formatSuperValuPricesForDisplay.getFormattedTotalPrice(linker.getSuperValuProductPrices()));
    }

    // method to turn the price breakdown display on/off
    private void togglePriceBreakdown()
    {
        if (breakdownTableLayout.getVisibility()==View.INVISIBLE)
        {
            breakdownTableLayout.setVisibility(View.VISIBLE);
            breakdownButton.setText("HIDE PRICE BREAKDOWN");
        }
        else
        {
            breakdownTableLayout.setVisibility(View.INVISIBLE);
            breakdownButton.setText("SHOW PRICE BREAKDOWN");

        }
    }

    // method to get format product names for display
    public String getFormattedProductNames(ArrayList<String> productNames)
    {
        String cutoffPrices = "";
        for (String item:productNames)
        {
            if (item.length() > MAX_CHARS)
            {
                cutoffPrices += item.substring(0, MAX_CHARS) + "\n";
            }
            else
            {
                cutoffPrices += item + "\n";
            }
        }
        return cutoffPrices;
    }
}
