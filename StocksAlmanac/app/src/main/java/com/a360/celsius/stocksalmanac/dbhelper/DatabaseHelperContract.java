package com.a360.celsius.stocksalmanac.dbhelper;

import android.content.Context;
import android.provider.BaseColumns;

/**
 * Created by dennisshar on 13/10/2017.
 */

public class DatabaseHelperContract {

    private static DatabaseHelperContract sInstance;


    public static synchronized DatabaseHelperContract getInstance() {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelperContract();
        }
        return sInstance;
    }

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DatabaseHelperContract() {}

    /* Inner class that defines the table contents */
    public static class QuotesDataTableContents implements BaseColumns {
        public static final String TABLE_NAME = "qoutes_data";
        public static final String COLUMN_NAME_SYMBOL = "symbol";
        public static final String COLUMN_NAME_EXCHANGE = "exchange";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DAYCODE = "dayCode";
        public static final String COLUMN_NAME_SERVERTIMESTAMP = "serverTimestamp";
        public static final String COLUMN_NAME_MODE = "mode";
        public static final String COLUMN_NAME_LASTPRICE = "lastPrice";
        public static final String COLUMN_NAME_TRADETIMESTAMP = "tradeTimestamp";
        public static final String COLUMN_NAME_NETCHANGE = "netChange";
        public static final String COLUMN_NAME_PERSENTCHANGE = "percentChange";
        public static final String COLUMN_NAME_UNITCODE = "unitCode";
        public static final String COLUMN_NAME_OPEN = "open";
        public static final String COLUMN_NAME_HIGH = "high";
        public static final String COLUMN_NAME_LOW = "low";
        public static final String COLUMN_NAME_CLOSE = "close";
        public static final String COLUMN_NAME_FLAG = "flag";
        public static final String COLUMN_NAME_VOLUME = "volume";
    }



    public static final String SQL_CREATE_QQUOTES_DATA_TABLE =
            "CREATE TABLE " + QuotesDataTableContents.TABLE_NAME + " (" +
                    QuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    QuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    QuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_QQUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + QuotesDataTableContents.TABLE_NAME;


}
