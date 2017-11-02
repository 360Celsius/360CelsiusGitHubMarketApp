package com.a360.celsius.stocksalmanac;

import android.content.Intent;
import android.os.Bundle;

import com.a360.celsius.stocksalmanac.service.StockDataPullService;
import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

/**
 * Created by dennisshar on 02/11/2017.
 */

public class SplashActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Intent msgIntent = new Intent(getApplicationContext(), StockDataPullService.class);
        msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_FINANCIALS_FROM_SPLASH_KEY);
        startService(msgIntent);

    }
}
