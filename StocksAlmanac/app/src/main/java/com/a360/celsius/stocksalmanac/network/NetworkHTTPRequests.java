package com.a360.celsius.stocksalmanac.network;

import android.content.Context;

import com.a360.celsius.stocksalmanac.R;

import java.util.ArrayList;

/**
 * Created by dennisshar on 12/10/2017.
 */

public class NetworkHTTPRequests {

    public static String API_KEY = "f3f97f8b7b2c97ed6f264ef13b957a98";
    public static String SERVER_DOMAIN = "http://marketdata.websol.barchart.com/getQuote.json";


    private static NetworkHTTPConnection networkHTTPConnection;
    Context ctx;

    public NetworkHTTPRequests(Context ctx) {
        networkHTTPConnection = NetworkHTTPConnection.getInstance();
        this.ctx = ctx;
    }

    private static String urlBuilder(String serverDomain, String apiKey, String[] qoutesList){
        String url = null;
        String quotesList = null;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<qoutesList.length;i++) {
            if(i!=qoutesList.length-1) {
                builder.append(qoutesList[i]);
                builder.append(",");
            }else{
                builder.append(qoutesList[i]);
            }
        }
        quotesList = builder.toString();

        url = serverDomain+"?apikey="+apiKey+"&symbols="+quotesList;
        return url;
    }

    public String getMaterials(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.materials_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getGoods(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.goods_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getServices(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.services_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getFinancials(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.financials_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getHelthCare(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.healthcare_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getIndastrial(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.industrials_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getOilandGas(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.oilandgas_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getTechnology(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.technology_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getUtilities(){
        String responce = null;
        String url = null;
        url = urlBuilder(SERVER_DOMAIN,API_KEY,ctx.getResources().getStringArray(R.array.utilities_quotes_list));
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }


}
