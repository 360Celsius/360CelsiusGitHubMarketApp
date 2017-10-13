package com.a360.celsius.stocksalmanac.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.a360.celsius.stocksalmanac.network.NetworkHTTPRequests;

/**
 * Created by dennisshar on 12/10/2017.
 */

public class StockDataPullService extends IntentService {

    public static final String GET_QOUTES_DATA = "GET_QOUTES_DATA";
    private static NetworkHTTPRequests networkHTTPRequests;


    @Override
    public void onCreate() {
        super.onCreate();
        networkHTTPRequests = new NetworkHTTPRequests(getApplicationContext());

    }

    public StockDataPullService() {
        super("StockDataPullService");
    }


    public StockDataPullService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        networkHTTPRequests.getMaterials();
    }
}
