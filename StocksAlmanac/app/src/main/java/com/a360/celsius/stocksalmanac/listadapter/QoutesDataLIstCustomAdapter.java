package com.a360.celsius.stocksalmanac.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a360.celsius.stocksalmanac.R;
import com.a360.celsius.stocksalmanac.datamodel.QuoteItemDataModel;
import com.a360.celsius.stocksalmanac.datamodel.SideMenuItemDataModel;

import java.util.ArrayList;

/**
 * Created by dennisshar on 24/10/2017.
 */

public class QoutesDataLIstCustomAdapter extends ArrayAdapter<QuoteItemDataModel> implements View.OnClickListener {

    private ArrayList<QuoteItemDataModel> dataSet;
    Context mContext;

    @Override
    public void onClick(View v) {

    }

    // View lookup cache
    private static class ViewHolder {
        TextView qouteName;

    }

    public QoutesDataLIstCustomAdapter(ArrayList<QuoteItemDataModel> data, Context context) {
        super(context, R.layout.quote_list_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        QuoteItemDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        //final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.quote_list_item, parent, false);
            viewHolder.qouteName = (TextView) convertView.findViewById(R.id.quote_name);

            //result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            //result=convertView;
        }

        viewHolder.qouteName.setText(dataModel.getName());

        // Return the completed view to render on screen
        return convertView;
    }

}
