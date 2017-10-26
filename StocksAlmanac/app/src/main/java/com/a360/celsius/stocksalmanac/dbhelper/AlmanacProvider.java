package com.a360.celsius.stocksalmanac.dbhelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.a360.celsius.stocksalmanac.dbhelper.DatabaseHelperContract.MaterialsQuotesDataTableContents.CONTENT_URI;

/**
 * Created by dennisshar on 14/10/2017.
 */

public class AlmanacProvider extends ContentProvider {

    public static DatabaseHelper helper = null;

    private static final int MATERIALS_QOUTES = 1;
    private static final int GOODS_QUOTES = 2;
    private static final int SERVICES_QUOTES = 3;
    private static final int FINANCIALS_QOUTES = 4;
    private static final int HEALTHCARE_QOUTES = 5;
    private static final int OILANDGAS_OUTES = 6;
    private static final int TECHNOLOGY_QOUTES = 7;
    private static final int UTILITIES_QOUTES = 8;
    private static final int INDUSTRIAL_OUTES = 9;


    private static final UriMatcher mMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.MaterialsQuotesDataTableContents.URI_SUFFIX, MATERIALS_QOUTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.GoodsQuotesDataTableContents.URI_SUFFIX, GOODS_QUOTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.ServicesQuotesDataTableContents.URI_SUFFIX, SERVICES_QUOTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.FinancialsQuotesDataTableContents.URI_SUFFIX, FINANCIALS_QOUTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.HealthCareQuotesDataTableContents.URI_SUFFIX, HEALTHCARE_QOUTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.OilANdGasQuotesDataTableContents.URI_SUFFIX, OILANDGAS_OUTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.TechnologyQuotesDataTableContents.URI_SUFFIX, TECHNOLOGY_QOUTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.UtilitiesQuotesDataTableContents.URI_SUFFIX, UTILITIES_QOUTES);
        mMatcher.addURI(DatabaseHelperContract.AUTHORITY, DatabaseHelperContract.IndustrialQuotesDataTableContents.URI_SUFFIX, INDUSTRIAL_OUTES);

    }

    @Override
    public boolean onCreate() {
        helper  = DatabaseHelper.getInstance(getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String nullColumnHack = null;
        long id = db.insert(getTableName(uri), nullColumnHack, values);

        if(id > -1){
            Uri insertedId = ContentUris.withAppendedId(getContentUriName(uri), id);
            getContext().getContentResolver().notifyChange(insertedId, null);
            return insertedId;
        }
        else
            return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    public static String getTableName(Uri uri) {
        String tableName = null;

        switch (mMatcher.match(uri)) {
            case MATERIALS_QOUTES:
                tableName = DatabaseHelperContract.MaterialsQuotesDataTableContents.TABLE_NAME;
                break;
            case GOODS_QUOTES:
                tableName = DatabaseHelperContract.GoodsQuotesDataTableContents.TABLE_NAME;
                break;
            case SERVICES_QUOTES:
                tableName = DatabaseHelperContract.ServicesQuotesDataTableContents.TABLE_NAME;
                break;
            case FINANCIALS_QOUTES:
                tableName = DatabaseHelperContract.FinancialsQuotesDataTableContents.TABLE_NAME;
                break;
            case HEALTHCARE_QOUTES:
                tableName = DatabaseHelperContract.HealthCareQuotesDataTableContents.TABLE_NAME;
                break;
            case OILANDGAS_OUTES:
                tableName = DatabaseHelperContract.OilANdGasQuotesDataTableContents.TABLE_NAME;
                break;
            case TECHNOLOGY_QOUTES:
                tableName = DatabaseHelperContract.TechnologyQuotesDataTableContents.TABLE_NAME;
                break;
            case UTILITIES_QOUTES:
                tableName = DatabaseHelperContract.UtilitiesQuotesDataTableContents.TABLE_NAME;
                break;
            case INDUSTRIAL_OUTES:
                tableName = DatabaseHelperContract.IndustrialQuotesDataTableContents.TABLE_NAME;
                break;
        }

        return tableName;
    }

    public Uri getContentUriName(Uri uri) {
        Uri contentUriName = null;

        switch (mMatcher.match(uri)) {
            case MATERIALS_QOUTES:
                contentUriName = DatabaseHelperContract.MaterialsQuotesDataTableContents.CONTENT_URI;
                break;
            case GOODS_QUOTES:
                contentUriName = DatabaseHelperContract.GoodsQuotesDataTableContents.CONTENT_URI;
                break;
            case SERVICES_QUOTES:
                contentUriName = DatabaseHelperContract.ServicesQuotesDataTableContents.CONTENT_URI;
                break;
            case FINANCIALS_QOUTES:
                contentUriName = DatabaseHelperContract.FinancialsQuotesDataTableContents.CONTENT_URI;
                break;
            case HEALTHCARE_QOUTES:
                contentUriName = DatabaseHelperContract.HealthCareQuotesDataTableContents.CONTENT_URI;
                break;
            case OILANDGAS_OUTES:
                contentUriName = DatabaseHelperContract.OilANdGasQuotesDataTableContents.CONTENT_URI;
                break;
            case TECHNOLOGY_QOUTES:
                contentUriName = DatabaseHelperContract.TechnologyQuotesDataTableContents.CONTENT_URI;
                break;
            case UTILITIES_QOUTES:
                contentUriName = DatabaseHelperContract.UtilitiesQuotesDataTableContents.CONTENT_URI;
                break;
            case INDUSTRIAL_OUTES:
                contentUriName = DatabaseHelperContract.IndustrialQuotesDataTableContents.CONTENT_URI;
                break;
        }

        return contentUriName;
    }
}
