package com.a360.celsius.stocksalmanac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.a360.celsius.stocksalmanac.service.StockDataPullService;
import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

/**
 * Created by dennisshar on 02/11/2017.
 */

public class SplashActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        setContentView(R.layout.splash_activity);

        Intent msgIntent = new Intent(getApplicationContext(), StockDataPullService.class);
        msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_FINANCIALS_FROM_SPLASH_KEY);
        startService(msgIntent);

    }
}
