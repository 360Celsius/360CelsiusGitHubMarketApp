package com.a360.celsius.stocksalmanac;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.a360.celsius.stocksalmanac.dbhelper.DatabaseHelper;
import com.a360.celsius.stocksalmanac.interfaces.DBhelperInterface;
import com.a360.celsius.stocksalmanac.recivers.BroadCastReciver;
import com.a360.celsius.stocksalmanac.service.StockDataPullService;


/**
 * Created by dennisshar on 13/10/2017.
 */

public class BaseActivity extends AppCompatActivity implements DBhelperInterface{

    public static DatabaseHelper helper = null;
    private BroadCastReciver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.tool_bar_color));
        }

        // In any activity just pass the context and use the singleton method
        helper = DatabaseHelper.getInstance(getApplicationContext());
    }


    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter(StockDataPullService.GET_QOUTES_DATA);
        receiver = new BroadCastReciver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }


    @Override
    public DatabaseHelper getDBhelper() {
        return helper;
    }
}
