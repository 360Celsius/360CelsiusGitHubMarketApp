package com.a360.celsius.stocksalmanac.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a360.celsius.stocksalmanac.JSONobj.Results;
import com.a360.celsius.stocksalmanac.R;
import com.a360.celsius.stocksalmanac.datamodel.QuoteItemDataModel;
import com.a360.celsius.stocksalmanac.interfaces.DBhelperInterface;
import com.a360.celsius.stocksalmanac.listadapter.QoutesDataLIstCustomAdapter;
import com.a360.celsius.stocksalmanac.service.StockDataPullService;
import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

/**
 * Created by dennisshar on 17/10/2017.
 */

public class ServicesQuotesFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_quotes, container, false);

        // Inflate the layout for this fragment
        //container.clearDisappearingChildren();


        listView=(ListView)view.findViewById(R.id.services_data_list);


        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.services_swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent msgIntent = new Intent(getContext(), StockDataPullService.class);
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_SERVICES_KEY);
                getContext().startService(msgIntent);

                // Remember to CLEAR OUT old items before appending in the new ones
                //adapter.clear();
                // ...the data has come back, add new items to your adapter...
                // adapter.addAll(...);
                // Now we call setRefreshing(false) to signal refresh has finished
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        results = mCallback.getDBhelper().getServicesData();
        progressBarInterface.getProgressBar().setVisibility(View.GONE);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for(int i=0;i<results.getQuoteData().size();i++){
            dataModels.add(new QuoteItemDataModel(
                    results.getQuoteData().get(i).getSymbol(),
                    results.getQuoteData().get(i).getExchange(),
                    results.getQuoteData().get(i).getName(),
                    results.getQuoteData().get(i).getLastPrice(),
                    results.getQuoteData().get(i).getTradeTimestamp(),
                    results.getQuoteData().get(i).getNetChange(),
                    results.getQuoteData().get(i).getPercentChange(),
                    results.getQuoteData().get(i).getOpen(),
                    results.getQuoteData().get(i).getHigh(),
                    results.getQuoteData().get(i).getLow(),
                    results.getQuoteData().get(i).getClose(),
                    results.getQuoteData().get(i).getVolume()));
        }

        adapter= new QoutesDataLIstCustomAdapter(dataModels,getContext());
        listView.setAdapter(adapter);

    }
}
