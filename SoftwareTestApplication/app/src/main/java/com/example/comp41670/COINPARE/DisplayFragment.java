package com.example.comp41670.COINPARE;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

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

        displayProductDetails();

        return myInflatedView;
    }

    private void displayProductDetails() {
        FormatTescoPricesForDisplay formatTescoPricesForDisplay = new FormatTescoPricesForDisplay();
        FormatSuperValuPricesForDisplay formatSuperValuPricesForDisplay = new FormatSuperValuPricesForDisplay();

        displayTotalPrices(formatTescoPricesForDisplay, formatSuperValuPricesForDisplay);
        displayBreakdownProducts();
        displayBreakdownPrices(formatTescoPricesForDisplay, formatSuperValuPricesForDisplay);
    }

    private void displayBreakdownProducts() {
        productNameView.setText(getFormattedProductNames());
    }

    private void displayBreakdownPrices(FormatTescoPricesForDisplay formatTescoPricesForDisplay, FormatSuperValuPricesForDisplay formatSuperValuPricesForDisplay) {
        tescoBreakdownView.setText(formatTescoPricesForDisplay.getFormattedBreakdownPrices(linker.getTescoProductPrices()));
        superValuBreakdownView.setText(formatSuperValuPricesForDisplay.getFormattedBreakdownPrices(linker.getSuperValuProductPrices()));
    }

    private void displayTotalPrices(FormatTescoPricesForDisplay formatTescoPricesForDisplay, FormatSuperValuPricesForDisplay formatSuperValuPricesForDisplay) {
        tescoPriceView.setText(formatTescoPricesForDisplay.getFormattedTotalPrice(linker.getTescoProductPrices()));
        superValuPriceView.setText(formatSuperValuPricesForDisplay.getFormattedTotalPrice(linker.getSuperValuProductPrices()));
    }

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

    private String getFormattedProductNames()
    {
        String cutoffPrices = "";
        for (String item:linker.getProductNames())
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
