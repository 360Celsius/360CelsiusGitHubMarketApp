package com.a360.celsius.stocksalmanac.JSONobj;

import java.util.ArrayList;

/**
 * Created by dennisshar on 13/10/2017.
 */

public class Results {

    ArrayList<QuoteData> quoteData;

    public Results() {
    }

    public ArrayList<QuoteData> getQuoteData() {
        return quoteData;
    }

    public void setQuoteData(ArrayList<QuoteData> quoteData) {
        this.quoteData = quoteData;
    }
}
