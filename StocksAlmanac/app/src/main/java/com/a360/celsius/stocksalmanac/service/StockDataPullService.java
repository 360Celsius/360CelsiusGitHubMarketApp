package com.a360.celsius.stocksalmanac.service;

import android.app.IntentService;
import android.content.Intent;

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



        if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_MATERIAL_KEY)){
            networkHTTPRequests.getMaterials();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_GOODS_KEY)){
            networkHTTPRequests.getGoods();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_SERVICES_KEY)){
            networkHTTPRequests.getServices();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_FINANCIALS_KEY)){
            networkHTTPRequests.getFinancials();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_HEALTHCARE_KEY)){
            networkHTTPRequests.getHelthCare();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_OILANDGAS_KEY)){
            networkHTTPRequests.getOilandGas();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_TECHNOLOGY_KEY)){
            networkHTTPRequests.getTechnology();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_UTILITIES_KEY)){
            networkHTTPRequests.getUtilities();

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_INDUSTRIAL_KEY)){
            networkHTTPRequests.getIndastrial();

        }
    }
}
