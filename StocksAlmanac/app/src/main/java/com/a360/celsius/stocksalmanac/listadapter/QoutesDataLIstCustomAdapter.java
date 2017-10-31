package com.a360.celsius.stocksalmanac.listadapter;

import android.content.Context;
import android.graphics.Color;
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

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        TextView quoteSymbol;
        TextView quoteLastPrice;
        View upOrDownColor;
        TextView netChange;
        TextView percentChange;
        TextView open;
        TextView close;
        TextView low;
        TextView high;
        TextView lastUpdate;
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
            viewHolder.quoteSymbol = (TextView) convertView.findViewById(R.id.quote_symbol);
            viewHolder.quoteLastPrice = (TextView) convertView.findViewById(R.id.quote_last_price);
            viewHolder.upOrDownColor = (View) convertView.findViewById(R.id.up_or_down_color);
            viewHolder.netChange = (TextView) convertView.findViewById(R.id.net_change_value);
            viewHolder.percentChange = (TextView) convertView.findViewById(R.id.percent_change_value);
            viewHolder.open = (TextView) convertView.findViewById(R.id.open_value);
            viewHolder.close = (TextView) convertView.findViewById(R.id.close_value);
            viewHolder.low = (TextView) convertView.findViewById(R.id.low_value);
            viewHolder.high = (TextView) convertView.findViewById(R.id.high_value);
            viewHolder.lastUpdate = (TextView) convertView.findViewById(R.id.quote_last_updated_value);
            //result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            //result=convertView;
        }

        viewHolder.qouteName.setText(dataModel.getName());
        viewHolder.quoteSymbol.setText(dataModel.getSymbol());
        viewHolder.quoteLastPrice.setText(String.valueOf(dataModel.getLastPrice()));
        if(String.valueOf(dataModel.getPercentChange()).contains("-") && !String.valueOf(dataModel.getPercentChange()).equalsIgnoreCase("0.0")) {
            viewHolder.upOrDownColor.setBackgroundColor(mContext.getResources().getColor(R.color.down_color));
            viewHolder.netChange.setTextColor(mContext.getResources().getColor(R.color.down_color));
            viewHolder.percentChange.setTextColor(mContext.getResources().getColor(R.color.down_color));
        }else if(!String.valueOf(dataModel.getPercentChange()).contains("-")&&!String.valueOf(dataModel.getPercentChange()).equalsIgnoreCase("0.0")) {
            viewHolder.upOrDownColor.setBackgroundColor(mContext.getResources().getColor(R.color.up_color));
            viewHolder.netChange.setTextColor(mContext.getResources().getColor(R.color.up_color));
            viewHolder.percentChange.setTextColor(mContext.getResources().getColor(R.color.up_color));
        }else {
            viewHolder.upOrDownColor.setBackgroundColor(mContext.getResources().getColor(R.color.no_change_color));
            viewHolder.netChange.setTextColor(mContext.getResources().getColor(R.color.no_change_color));
            viewHolder.percentChange.setTextColor(mContext.getResources().getColor(R.color.no_change_color));
        }


        viewHolder.netChange.setText(String.valueOf(dataModel.getNetChange()));
        viewHolder.percentChange.setText(String.valueOf(dataModel.getPercentChange()));
        viewHolder.open.setText(String.valueOf(dataModel.getOpen()));
        viewHolder.close.setText(String.valueOf(dataModel.getClose()));
        viewHolder.low.setText(String.valueOf(dataModel.getLow()));
        viewHolder.high.setText(String.valueOf(dataModel.getHigh()));

        String dateString = dataModel.getTradeTimeStamp();//"2010-03-01T00:00:00-08:00";
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        String dateToString = null;
        try {
            date = sdf.parse(dateString);
            dateToString = date.toString();
        } catch (ParseException e) {
            e.printStackTrace();
            dateToString = "N/A";
        }

        viewHolder.lastUpdate.setText(dateToString);

        // Return the completed view to render on screen
        return convertView;
    }

}
