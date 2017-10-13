package com.a360.celsius.stocksalmanac.service;

import android.app.IntentService;
import android.content.Intent;

import com.a360.celsius.stocksalmanac.ISONparser.JSONparser;
import com.a360.celsius.stocksalmanac.network.NetworkHTTPRequests;

/**
 * Created by dennisshar on 12/10/2017.
 */

public class StockDataPullService extends IntentService {

    public static final String GET_QOUTES_DATA = "GET_QOUTES_DATA";
    private static NetworkHTTPRequests networkHTTPRequests;
    private static JSONparser jSONparser;

    @Override
    public void onCreate() {
        super.onCreate();
        networkHTTPRequests = new NetworkHTTPRequests(getApplicationContext());
        jSONparser = new JSONparser();
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

            String getMaterialsResponce = null;
            getMaterialsResponce = networkHTTPRequests.getMaterials();
            jSONparser.getStatusFromJson(getMaterialsResponce);
            jSONparser.getResultsFromJson(getMaterialsResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_GOODS_KEY)){

            String getGoodsResponce = null;
            getGoodsResponce = networkHTTPRequests.getGoods();
            jSONparser.getStatusFromJson(getGoodsResponce);
            jSONparser.getResultsFromJson(getGoodsResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_SERVICES_KEY)){

            String getServicesResponce = null;
            getServicesResponce = networkHTTPRequests.getServices();
            jSONparser.getStatusFromJson(getServicesResponce);
            jSONparser.getResultsFromJson(getServicesResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_FINANCIALS_KEY)){

            String getFinancialsResponce = null;
            getFinancialsResponce = networkHTTPRequests.getFinancials();
            jSONparser.getStatusFromJson(getFinancialsResponce);
            jSONparser.getResultsFromJson(getFinancialsResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_HEALTHCARE_KEY)){

            String getHelthCareResponce = null;
            getHelthCareResponce = networkHTTPRequests.getHelthCare();
            jSONparser.getStatusFromJson(getHelthCareResponce);
            jSONparser.getResultsFromJson(getHelthCareResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_OILANDGAS_KEY)){

            String getOilandGasResponce = null;
            getOilandGasResponce = networkHTTPRequests.getOilandGas();
            jSONparser.getStatusFromJson(getOilandGasResponce);
            jSONparser.getResultsFromJson(getOilandGasResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_TECHNOLOGY_KEY)){

            String getTechnologyResponce = null;
            getTechnologyResponce = networkHTTPRequests.getTechnology();
            jSONparser.getStatusFromJson(getTechnologyResponce);
            jSONparser.getResultsFromJson(getTechnologyResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_UTILITIES_KEY)){

            String getUtilitiesResponce = null;
            getUtilitiesResponce = networkHTTPRequests.getUtilities();
            jSONparser.getStatusFromJson(getUtilitiesResponce);
            jSONparser.getResultsFromJson(getUtilitiesResponce);

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_INDUSTRIAL_KEY)){

            String getIndastrialResponce = null;
            getIndastrialResponce = networkHTTPRequests.getIndastrial();
            jSONparser.getStatusFromJson(getIndastrialResponce);
            jSONparser.getResultsFromJson(getIndastrialResponce);

        }
    }
}
