package com.example.seancasey.softwaretestapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

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

        //Pattern p = Pattern.compile(".*[p]rice\\:(\\d+\\.\\d+)");
        /*Pattern p = Pattern.compile(".*?[p]rice\\:(\\d+(\\.\\d+)*).*");

        String myString = "Find the first price10.8 Hello price:9.3 nextprice:11.1123";
        Matcher m = p.matcher(myString);
        boolean b = m.matches();
        String newString = null;
        if (b)
        {
            newString = m.group(1);
            Toast.makeText(getActivity(), "YES, PRICE = " + newString, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getActivity(), "NO", Toast.LENGTH_SHORT).show();
        }*/

        ///////////////////////////////////////////////
        ///////////////////////////////////////////////

        ///// HTML RELATED CODE STARTS BELOW HERE /////

        ///////////////////////////////////////////////
        ///////////////////////////////////////////////

        //METHOD 1 - UNCOMMENT ALL THESE LINES TO USE METHOD 1

        //String content = null;
        //URLConnection connection = null;
        //try {
        //    connection =  new URL("https://www.tesco.ie/groceries/product/search/default.aspx?searchBox=milk").openConnection();
        //    Scanner scanner = new Scanner(connection.getInputStream());
        //    scanner.useDelimiter("\\Z");
        //    content = scanner.next();
        //}catch ( Exception ex ) {
        //    ex.printStackTrace();
        //    Log.d("ABCD", ex.toString());
        //}
        // END OF METHOD 1

        // METHOD 2 AND 3 INSIDE THIS try BLOCK

        //Document doc = null;
        //try {
            //UNCOMMENT OUT ONE OF THESE TO DECIDE WHICH TO USE (METHOD 2 or 3)

            //method2();
            //method3();
        //}
        //catch (Exception ex)
        //{
        //    ex.printStackTrace();
        //    Log.d("ABCD", ex.toString());
        //}


        //String html = Jsoup.connect("https://www.tesco.ie/groceries/product/search/default.aspx?searchBox=milk").get().html();

        return myInflatedView;
    }


    public void method2() throws Exception
    {
        URL oracle = new URL("https://www.tesco.ie/groceries/product/search/default.aspx?searchBox=cake");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            //System.out.println(inputLine);
        }
        in.close();
    }

    public Document method3() throws Exception
    {
        //String html = Jsoup.connect("https://www.ismyinternetworking.com/").get().html();
        Document document = Jsoup.connect("https://www.ismyinternetworking.com/").get();
        return document;
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
