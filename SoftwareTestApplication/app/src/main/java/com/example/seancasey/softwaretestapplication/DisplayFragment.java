package com.example.seancasey.softwaretestapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.seancasey.softwaretestapplication.MyValues.EURO_SYMBOL;
import static com.example.seancasey.softwaretestapplication.MyValues.EXCHANGE_RATE;
import static com.example.seancasey.softwaretestapplication.MyValues.MAX_CHARS;
import static java.lang.Math.round;

public class DisplayFragment extends Fragment {

    private View myInflatedView;
    private Linker linker;

    private double totalPrice;
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

        tescoPriceView.setText(EURO_SYMBOL +String.valueOf(getTotalPrice(getPriceInEuro())));
        superValuPriceView.setText(EURO_SYMBOL+String.valueOf(getTotalPrice(getPricesAsDoubles(linker.getSuperValuProductPrices()))));
        productNameView.setText(getFormattedNames());
        tescoBreakdownView.setText(getFormattedPrices(getPriceInEuro()));
        superValuBreakdownView.setText(getFormattedPrices(getPricesAsDoubles(linker.getSuperValuProductPrices())));

        return myInflatedView;
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

    private ArrayList<Double> getPriceInEuro()
    {
        double price;
        ArrayList<Double> priceInEuro =  new ArrayList<>();
        for (String item:linker.getTescoProductPrices())
        {
            price = poundToEuro(Double.valueOf(item));
            price = roundToNearestCent(price);
            priceInEuro.add(price);
        }
        return priceInEuro;
    }

    private ArrayList<Double> getPricesAsDoubles(ArrayList<String> stringPrices)
    {
        ArrayList<Double> doublePrices = new ArrayList<>();
        for (String stringPrice:stringPrices)
        {
            double doublePrice = Double.valueOf(stringPrice);
            doublePrices.add(doublePrice);
        }
        return doublePrices;
    }

    private double roundToNearestCent(double price) {
        price = round(price*100.0)/100.0;
        return price;
    }

    private double getTotalPrice(ArrayList<Double> prices)
    {
        //ArrayList<Double>PriceInEuro = getPriceInEuro();
        double totalPrice = 0.0;
        for (double price:prices)
        {
            totalPrice += price;
        }
        return totalPrice;
    }

    private double poundToEuro(double pound)
    {
        return pound * EXCHANGE_RATE;
    }

    private String getFormattedNames()
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

    private String getFormattedPrices(ArrayList<Double> prices)
    {
        String breakdownPrices = "";
        for (double price:prices)
        {
            breakdownPrices +=  "€" + price + "\n";
        }
        return breakdownPrices;
    }



}
