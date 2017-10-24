package com.a360.celsius.stocksalmanac.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.a360.celsius.stocksalmanac.JSONobj.QuoteData;
import com.a360.celsius.stocksalmanac.JSONobj.Results;

import java.util.ArrayList;

/**
 * Created by dennisshar on 13/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    // Database Info
    private static final String DATABASE_NAME = "stocksalmanacDatabase";
    private static final int DATABASE_VERSION = 2;
    Context context;

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseHelperContract.SQL_CREATE_MATERIALS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_GOODS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_SERVICES_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_FINANCIALS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_HEALTHCARE_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_OILANDGAS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_TECHNOLOGY_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_UTILITIES_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_CREATE_INDUSTRIAL_QUOTES_DATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DatabaseHelperContract.SQL_DELETE_MATERIALS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_GOODS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_SERVICES_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_FINANCIALS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_HEALTHCARE_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_OILANDGAS_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_TECHNOLOGY_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_UTILITIES_QUOTES_DATA_TABLE);
        db.execSQL(DatabaseHelperContract.SQL_DELETE_INDUSTRIAL_QUOTES_DATA_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


    //=============================MATERIALS========================================

    public void bulkInsertMaterialsQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.MaterialsQuotesDataTableContents.CONTENT_URI, contentsArr);
    }

    public void addMaterialsQuoteDataToQuotesTable(Results results){
        deleteMaterialsQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.MaterialsQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteMaterialsQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.MaterialsQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getMaterialsData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_MATERIALS_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.MaterialsQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }

    //=============================GOODS========================================

    public void bulkInsertGoodsQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.GoodsQuotesDataTableContents.CONTENT_URI, contentsArr);
    }

    public void addGoodsQuoteDataToQuotesTable(Results results){
        deleteGoodsQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.GoodsQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteGoodsQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.GoodsQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getGoodsData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_GOODS_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.GoodsQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
    //=============================SERVICES========================================

    public void bulkInsertServicesQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.ServicesQuotesDataTableContents.CONTENT_URI, contentsArr);
    }

    public void addServicesQuoteDataToQuotesTable(Results results){
        deleteServicesQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.ServicesQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteServicesQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.ServicesQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getServicesData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_SERVICES_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.ServicesQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
    //=============================FINANCIALS========================================

    public void bulkInsertFinancialsQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.FinancialsQuotesDataTableContents.CONTENT_URI, contentsArr);
    }

    public void addFinancialsQuoteDataToQuotesTable(Results results){
        deleteFinancialsQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.FinancialsQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteFinancialsQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.FinancialsQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getFinancialsData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_FINANCIALS_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.FinancialsQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
    //=============================HEALTHCARE========================================

    public void bulkInsertHealthCareQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.HealthCareQuotesDataTableContents.CONTENT_URI, contentsArr);
    }


    public void addHealthCareQuoteDataToQuotesTable(Results results){
        deleteHealthCareQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.HealthCareQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteHealthCareQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.HealthCareQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getHealthCAreData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_HEALTHCARE_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.HealthCareQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
    //=============================OILANDGAS========================================

    public void bulkInsertOilAndGasQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.OilANdGasQuotesDataTableContents.CONTENT_URI, contentsArr);
    }

    public void addOilAndGasQuoteDataToQuotesTable(Results results){
        deleteOilAndGasQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.OilANdGasQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteOilAndGasQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.OilANdGasQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getOilANdGasData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_OILANDGAS_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.OilANdGasQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
    //=============================TECHNOLOGY========================================

    public void bulkInsertTechnologyQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.TechnologyQuotesDataTableContents.CONTENT_URI, contentsArr);
    }

    public void addTechnologyQuoteDataToQuotesTable(Results results){
        deleteTechnologyQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.TechnologyQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteTechnologyQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.TechnologyQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getTechnologyData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_TECHNOLOGY_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.TechnologyQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
    //=============================UTILITIES========================================

    public void bulkInsertUtilitiesQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.UtilitiesQuotesDataTableContents.CONTENT_URI, contentsArr);
    }

    public void addUtilitiesQuoteDataToQuotesTable(Results results){
        deleteUtilitiesQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.UtilitiesQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteUtilitiesQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.UtilitiesQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getUtilitiesData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_UTILITIES_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
    //=============================INDUSTRIAL========================================

    public void bulkInsertIndustrialQuoteDataToQuotesTable(Results results) {
        deleteMaterialsQuoteDataTable();
        ContentValues[] contentsArr = new ContentValues[results.getQuoteData().size()];;
        for(int i=0;i<results.getQuoteData().size();i++){
            ContentValues values = new ContentValues();
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
            values.put(DatabaseHelperContract.UtilitiesQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
            values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());
            contentsArr[i] = values;
        }

        context.getContentResolver().bulkInsert(DatabaseHelperContract.IndustrialQuotesDataTableContents.CONTENT_URI, contentsArr);
    }


    public void addIndustrialQuoteDataToQuotesTable(Results results){
        deleteIndustrialQuoteDataTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<results.getQuoteData().size();i++){

                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_SYMBOL, results.getQuoteData().get(i).getSymbol());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_EXCHANGE, results.getQuoteData().get(i).getExchange());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_NAME, results.getQuoteData().get(i).getName());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_DAYCODE, results.getQuoteData().get(i).getDayCode());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP, results.getQuoteData().get(i).getServerTimestamp());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_MODE, results.getQuoteData().get(i).getMode());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_LASTPRICE, results.getQuoteData().get(i).getLastPrice());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP, results.getQuoteData().get(i).getTradeTimestamp());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_NETCHANGE, results.getQuoteData().get(i).getNetChange());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE, results.getQuoteData().get(i).getPercentChange());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_UNITCODE, results.getQuoteData().get(i).getUnitCode());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_OPEN, results.getQuoteData().get(i).getOpen());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_HIGH, results.getQuoteData().get(i).getHigh());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_LOW, results.getQuoteData().get(i).getLow());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_CLOSE, results.getQuoteData().get(i).getClose());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_FLAG, results.getQuoteData().get(i).getFlag());
                values.put(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_VOLUME, results.getQuoteData().get(i).getVolume());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DatabaseHelperContract.IndustrialQuotesDataTableContents.TABLE_NAME, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteIndustrialQuoteDataTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DatabaseHelperContract.IndustrialQuotesDataTableContents.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Results getIndustrialData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DatabaseHelperContract.SQL_SELECT_INDUSTRIAL_QUOTES_DATA_TABLE, null);

        Results resulteList = new Results();
        ArrayList<QuoteData> quoteDataList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    QuoteData quoteData = new QuoteData();
                    quoteData.setSymbol(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_SYMBOL)));
                    quoteData.setExchange(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_EXCHANGE)));
                    quoteData.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_NAME)));
                    quoteData.setDayCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_DAYCODE)));
                    quoteData.setServerTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_SERVERTIMESTAMP)));
                    quoteData.setMode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_MODE)));
                    quoteData.setLastPrice(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_LASTPRICE)));
                    quoteData.setTradeTimestamp(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_TRADETIMESTAMP)));
                    quoteData.setNetChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_NETCHANGE)));
                    quoteData.setPercentChange(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_PERSENTCHANGE)));
                    quoteData.setUnitCode(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_UNITCODE)));
                    quoteData.setOpen(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_OPEN)));
                    quoteData.setHigh(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_HIGH)));
                    quoteData.setLow(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_LOW)));
                    quoteData.setClose(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_CLOSE)));
                    quoteData.setFlag(cursor.getString(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_FLAG)));
                    quoteData.setVolume(cursor.getDouble(cursor.getColumnIndex(DatabaseHelperContract.IndustrialQuotesDataTableContents.COLUMN_NAME_VOLUME)));

                    quoteDataList.add(quoteData);
                } while (cursor.moveToNext());

                resulteList.setQuoteData(quoteDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return resulteList;
    }
}
