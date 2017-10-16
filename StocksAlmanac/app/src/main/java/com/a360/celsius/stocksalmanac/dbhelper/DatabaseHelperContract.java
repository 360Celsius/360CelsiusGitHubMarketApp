package com.a360.celsius.stocksalmanac.dbhelper;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.Locale;

/**
 * Created by dennisshar on 13/10/2017.
 */

public class DatabaseHelperContract {

    public static final String packageName = "com.a360.celsius.stocksalmanac";
    public static final String AUTHORITY = packageName + ".provider";
    public static final String CONTENT_BASE = "content://"+AUTHORITY+"/%s";

    private DatabaseHelperContract() {}

    //=============================MATERIALS========================================
    /* Inner class that defines the table contents */
    public static class MaterialsQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "materials_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "materials_qoutes_data";
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



    public static final String SQL_CREATE_MATERIALS_QUOTES_DATA_TABLE =
            "CREATE TABLE " + MaterialsQuotesDataTableContents.TABLE_NAME + " (" +
                    MaterialsQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    MaterialsQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_MATERIALS_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + MaterialsQuotesDataTableContents.TABLE_NAME;

    //=============================GOODS========================================
    /* Inner class that defines the table contents */
    public static class GoodsQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "goods_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "goods_qoutes_data";
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



    public static final String SQL_CREATE_GOODS_QUOTES_DATA_TABLE =
            "CREATE TABLE " + GoodsQuotesDataTableContents.TABLE_NAME + " (" +
                    GoodsQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    GoodsQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_GOODS_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + GoodsQuotesDataTableContents.TABLE_NAME;


    //=============================SERVICES========================================
    /* Inner class that defines the table contents */
    public static class ServicesQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "services_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "services_qoutes_data";
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



    public static final String SQL_CREATE_SERVICES_QUOTES_DATA_TABLE =
            "CREATE TABLE " + ServicesQuotesDataTableContents.TABLE_NAME + " (" +
                    ServicesQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    ServicesQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_SERVICES_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + ServicesQuotesDataTableContents.TABLE_NAME;

    //=============================FINANCIALS========================================
    /* Inner class that defines the table contents */
    public static class FinancialsQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "financials_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "financials_qoutes_data";
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



    public static final String SQL_CREATE_FINANCIALS_QUOTES_DATA_TABLE =
            "CREATE TABLE " + FinancialsQuotesDataTableContents.TABLE_NAME + " (" +
                    FinancialsQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    FinancialsQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_FINANCIALS_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + FinancialsQuotesDataTableContents.TABLE_NAME;

    //=============================HEALTHCARE========================================
    /* Inner class that defines the table contents */
    public static class HealthCareQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "healthcare_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "healthcare_qoutes_data";
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



    public static final String SQL_CREATE_HEALTHCARE_QUOTES_DATA_TABLE =
            "CREATE TABLE " + HealthCareQuotesDataTableContents.TABLE_NAME + " (" +
                    HealthCareQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    HealthCareQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_HEALTHCARE_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + HealthCareQuotesDataTableContents.TABLE_NAME;

    //=============================OILANDGAS========================================
    /* Inner class that defines the table contents */
    public static class OilANdGasQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "oilandgas_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "oilandgas_qoutes_data";
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



    public static final String SQL_CREATE_OILANDGAS_QUOTES_DATA_TABLE =
            "CREATE TABLE " + OilANdGasQuotesDataTableContents.TABLE_NAME + " (" +
                    OilANdGasQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    OilANdGasQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_OILANDGAS_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + OilANdGasQuotesDataTableContents.TABLE_NAME;

    //=============================TECHNOLOGY========================================
    /* Inner class that defines the table contents */
    public static class TechnologyQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "technology_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "technology_qoutes_data";
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



    public static final String SQL_CREATE_TECHNOLOGY_QUOTES_DATA_TABLE =
            "CREATE TABLE " + TechnologyQuotesDataTableContents.TABLE_NAME + " (" +
                    TechnologyQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    TechnologyQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_TECHNOLOGY_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + TechnologyQuotesDataTableContents.TABLE_NAME;

    //=============================UTILITIES========================================
    /* Inner class that defines the table contents */
    public static class UtilitiesQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "utilities_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "utilities_qoutes_data";
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



    public static final String SQL_CREATE_UTILITIES_QUOTES_DATA_TABLE =
            "CREATE TABLE " + UtilitiesQuotesDataTableContents.TABLE_NAME + " (" +
                    UtilitiesQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    UtilitiesQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_UTILITIES_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + UtilitiesQuotesDataTableContents.TABLE_NAME;

    //=============================INDUSTRIAL========================================
    /* Inner class that defines the table contents */
    public static class IndustrialQuotesDataTableContents implements BaseColumns {

        public static final String URI_SUFFIX = "industrial_qoutes_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "industrial_qoutes_data";
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



    public static final String SQL_CREATE_INDUSTRIAL_QUOTES_DATA_TABLE =
            "CREATE TABLE " + IndustrialQuotesDataTableContents.TABLE_NAME + " (" +
                    IndustrialQuotesDataTableContents._ID + " INTEGER PRIMARY KEY," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_SYMBOL + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_EXCHANGE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_NAME + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_DAYCODE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_MODE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_LASTPRICE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_NETCHANGE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_UNITCODE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_OPEN + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_HIGH + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_LOW + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_CLOSE + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_FLAG + " TEXT," +
                    IndustrialQuotesDataTableContents.COLUMN_NAME_VOLUME + " TEXT)";

    public static final String SQL_DELETE_INDUSTRIAL_QUOTES_DATA_TABLE =
            "DROP TABLE IF EXISTS " + IndustrialQuotesDataTableContents.TABLE_NAME;
}
