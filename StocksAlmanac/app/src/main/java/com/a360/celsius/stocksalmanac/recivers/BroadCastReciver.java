package com.a360.celsius.stocksalmanac.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.a360.celsius.stocksalmanac.JSONobj.Status;
import com.a360.celsius.stocksalmanac.R;
import com.a360.celsius.stocksalmanac.fragments.FinancialsQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.GoodsQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.HealthCareQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.IndustrialQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.MaterialsQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.OilAndGasQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.ServicesQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.TechnologyQuotesFragment;
import com.a360.celsius.stocksalmanac.fragments.UtilitiesQuotesFragment;
import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

/**
 * Created by dennisshar on 21/10/2017.
 */

public class BroadCastReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY) );

        FragmentTransaction ft =   ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();

        if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_MATERIAL_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new MaterialsQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_GOODS_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new GoodsQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_SERVICES_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new ServicesQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_FINANCIALS_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new FinancialsQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_HEALTHCARE_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new HealthCareQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_OILANDGAS_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new OilAndGasQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_TECHNOLOGY_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new TechnologyQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_UTILITIES_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new UtilitiesQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(intent.getStringExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY).equalsIgnoreCase(StockDataPullServiceIntentKeys.DATA_TYPE_INDUSTRIAL_KEY)){
            try {
                ft.replace(R.id.list_view_placeholder, new IndustrialQuotesFragment());
                ft.commit();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}