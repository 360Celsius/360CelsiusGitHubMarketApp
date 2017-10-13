package com.a360.celsius.stocksalmanac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a360.celsius.stocksalmanac.service.StockDataPullService;
import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent msgIntentGetExternalIP = new Intent(getApplicationContext(), StockDataPullService.class);
        msgIntentGetExternalIP.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY,StockDataPullServiceIntentKeys.DATA_TYPE_GOODS_KEY);
        startService(msgIntentGetExternalIP);

//        String[] qoutesList = getResources().getStringArray(R.array.materials_quotes_list);
//
//        StringBuilder builder = new StringBuilder();
//        for(int i=0;i<qoutesList.length;i++) {
//            if(i!=qoutesList.length-1) {
//                builder.append(qoutesList[i]);
//                builder.append(",");
//            }else{
//                builder.append(qoutesList[i]);
//            }
//        }
//        String str = builder.toString();
    }
}
