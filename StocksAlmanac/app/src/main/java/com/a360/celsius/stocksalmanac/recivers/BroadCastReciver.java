package com.a360.celsius.stocksalmanac.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

/**
 * Created by dennisshar on 21/10/2017.
 */

public class BroadCastReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY) );

    }
}
