package com.a360.celsius.stocksalmanac.ISONparser;

import com.a360.celsius.stocksalmanac.JSONobj.QuoteData;
import com.a360.celsius.stocksalmanac.JSONobj.Results;
import com.a360.celsius.stocksalmanac.JSONobj.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dennisshar on 13/10/2017.
 */

public class JSONparser {

    public JSONparser() {
    }

    public Status getStatusFromJson (String requestResponce){
        JSONObject reader = null;
        JSONObject statusJSONObject = null;
        Status status = new Status();
        try {
            reader = new JSONObject(requestResponce);
            statusJSONObject  = reader.getJSONObject(JSONparserDict.STATUS);
            status.setCode(statusJSONObject.optInt(JSONparserDict.CODE,0));
            status.setMessage(statusJSONObject.optString(JSONparserDict.MESSAGE,null));

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return status;
    }

    public Results getResultsFromJson (String requestResponce){
        JSONObject reader = null;
        JSONArray resultsObject = null;
        Results resultes = null;
        try {
            reader = new JSONObject(requestResponce);
            resultsObject  = reader.getJSONArray(JSONparserDict.RESULTS);
            ArrayList<QuoteData> quoteDataList = new ArrayList();
            resultes = new Results();
            for (int i = 0; i < resultsObject.length(); i++) {
                JSONObject quoteItemData = resultsObject.getJSONObject(i);
                QuoteData quoteData = new QuoteData();
                quoteData.setSymbol(quoteItemData.optString(JSONparserDict.SYMBOL,null));
                quoteData.setExchange(quoteItemData.optString(JSONparserDict.EXCHANGE,null));
                quoteData.setName(quoteItemData.optString(JSONparserDict.NAME,null));
                quoteData.setDayCode(quoteItemData.optString(JSONparserDict.DAY_CODE,null));
                quoteData.setServerTimestamp(quoteItemData.optString(JSONparserDict.SERVER_TIMESTAMP,null));
                quoteData.setMode(quoteItemData.optString(JSONparserDict.MODE,null));
                quoteData.setLastPrice(quoteItemData.optDouble(JSONparserDict.LAST_PRICE,0));
                quoteData.setTradeTimestamp(quoteItemData.optString(JSONparserDict.TRADE_TIMESTAMP,null));
                quoteData.setNetChange(quoteItemData.optDouble(JSONparserDict.NET_CHANGE,0));
                quoteData.setPercentChange(quoteItemData.optDouble(JSONparserDict.PERCENT_CHANGE,0));
                quoteData.setUnitCode(quoteItemData.optString(JSONparserDict.UNIT_CODE,null));
                quoteData.setOpen(quoteItemData.optDouble(JSONparserDict.OPEN,0));
                quoteData.setClose(quoteItemData.optDouble(JSONparserDict.CLOSE,0));
                quoteData.setFlag(quoteItemData.optString(JSONparserDict.FLAG,null));
                quoteData.setVolume(quoteItemData.optDouble(JSONparserDict.VOLUME,0));
                quoteDataList.add(quoteData);
            }
            resultes.setQuoteData(quoteDataList);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return resultes;
    }
}