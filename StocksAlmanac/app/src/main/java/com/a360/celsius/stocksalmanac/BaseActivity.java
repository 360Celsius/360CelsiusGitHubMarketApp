package com.a360.celsius.stocksalmanac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.a360.celsius.stocksalmanac.dbhelper.DatabaseHelper;


/**
 * Created by dennisshar on 13/10/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // In any activity just pass the context and use the singleton method
        DatabaseHelper helper = DatabaseHelper.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
