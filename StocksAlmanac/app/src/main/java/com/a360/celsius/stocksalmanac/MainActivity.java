package com.a360.celsius.stocksalmanac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a360.celsius.stocksalmanac.service.StockDataPullService;
import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent msgIntentGetExternalIP = new Intent(getApplicationContext(), StockDataPullService.class);
        msgIntentGetExternalIP.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY,StockDataPullServiceIntentKeys.DATA_TYPE_MATERIAL_KEY);
        startService(msgIntentGetExternalIP);


    }
}
