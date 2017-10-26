package com.a360.celsius.stocksalmanac.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a360.celsius.stocksalmanac.JSONobj.Results;
import com.a360.celsius.stocksalmanac.datamodel.QuoteItemDataModel;
import com.a360.celsius.stocksalmanac.interfaces.DBhelperInterface;
import com.a360.celsius.stocksalmanac.listadapter.QoutesDataLIstCustomAdapter;

import java.util.ArrayList;

/**
 * Created by dennisshar on 24/10/2017.
 */

public class BaseFragment extends Fragment{

    public static QoutesDataLIstCustomAdapter adapter;
    public SwipeRefreshLayout mSwipeRefreshLayout;

    public DBhelperInterface mCallback;
    public Results results;
    public ArrayList<QuoteItemDataModel> dataModels;
    public ListView listView;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dataModels= new ArrayList<>();
        mCallback = (DBhelperInterface) activity;

    }
}
