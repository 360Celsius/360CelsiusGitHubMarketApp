package com.a360.celsius.stocksalmanac.service;

import android.app.IntentService;
import android.content.Intent;

import com.a360.celsius.stocksalmanac.BaseActivity;
import com.a360.celsius.stocksalmanac.ISONparser.JSONparser;
import com.a360.celsius.stocksalmanac.JSONobj.Status;
import com.a360.celsius.stocksalmanac.dbhelper.DatabaseHelper;
import com.a360.celsius.stocksalmanac.network.NetworkHTTPRequests;

/**
 * Created by dennisshar on 12/10/2017.
 */

public class StockDataPullService extends IntentService {

    public static final String GET_QOUTES_DATA = "GET_QOUTES_DATA";
    private static NetworkHTTPRequests networkHTTPRequests;
    private static JSONparser jSONparser;
    private DatabaseHelper helper;


    @Override
    public void onCreate() {
        super.onCreate();
        networkHTTPRequests = new NetworkHTTPRequests(getApplicationContext());
        jSONparser = new JSONparser();
        helper = BaseActivity.helper;
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
            try {
                String getMaterialsResponce = null;
                getMaterialsResponce = networkHTTPRequests.getMaterials();
                Status status = jSONparser.getStatusFromJson(getMaterialsResponce);
                if (status != null && status.getCode() == 200)
                    helper.addMaterialsQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getMaterialsResponce));

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_GOODS_KEY)){
            try {
                String getGoodsResponce = null;
                getGoodsResponce = networkHTTPRequests.getGoods();
                Status status = jSONparser.getStatusFromJson(getGoodsResponce);
                if (status != null && status.getCode() == 200)
                    helper.addGoodsQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getGoodsResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_SERVICES_KEY)){
            try {
                String getServicesResponce = null;
                getServicesResponce = networkHTTPRequests.getServices();
                Status status = jSONparser.getStatusFromJson(getServicesResponce);
                if (status != null && status.getCode() == 200)
                    helper.addServicesQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getServicesResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_FINANCIALS_KEY)){
            try {
                String getFinancialsResponce = null;
                getFinancialsResponce = networkHTTPRequests.getFinancials();
                Status status = jSONparser.getStatusFromJson(getFinancialsResponce);
                if (status != null && status.getCode() == 200)
                    helper.addFinancialsQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getFinancialsResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_HEALTHCARE_KEY)){
            try {
                String getHelthCareResponce = null;
                getHelthCareResponce = networkHTTPRequests.getHelthCare();
                Status status = jSONparser.getStatusFromJson(getHelthCareResponce);
                if (status != null && status.getCode() == 200)
                    helper.addHealthCareQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getHelthCareResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_OILANDGAS_KEY)){
            try {
                String getOilandGasResponce = null;
                getOilandGasResponce = networkHTTPRequests.getOilandGas();
                Status status = jSONparser.getStatusFromJson(getOilandGasResponce);
                if (status != null && status.getCode() == 200)
                    helper.addOilAndGasQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getOilandGasResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_TECHNOLOGY_KEY)){
            try {
                String getTechnologyResponce = null;
                getTechnologyResponce = networkHTTPRequests.getTechnology();
                Status status = jSONparser.getStatusFromJson(getTechnologyResponce);
                if (status != null && status.getCode() == 200)
                    helper.addTechnologyQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getTechnologyResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_UTILITIES_KEY)){
            try {
                String getUtilitiesResponce = null;
                getUtilitiesResponce = networkHTTPRequests.getUtilities();
                Status status = jSONparser.getStatusFromJson(getUtilitiesResponce);
                if (status != null && status.getCode() == 200)
                    helper.addUtilitiesQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getUtilitiesResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_INDUSTRIAL_KEY)){
            try {
                String getIndastrialResponce = null;
                getIndastrialResponce = networkHTTPRequests.getIndastrial();
                Status status = jSONparser.getStatusFromJson(getIndastrialResponce);
                if (status != null && status.getCode() == 200)
                    helper.addIndustrialQuoteDataToQuotesTable(jSONparser.getResultsFromJson(getIndastrialResponce));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
