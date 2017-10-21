package com.a360.celsius.stocksalmanac.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a360.celsius.stocksalmanac.R;
import com.a360.celsius.stocksalmanac.interfaces.DBhelperInterface;

/**
 * Created by dennisshar on 17/10/2017.
 */

public class FinancialsQuotesFragment extends Fragment {

    private DBhelperInterface mCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materials_quotes, container, false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DBhelperInterface) activity;

    }
}
