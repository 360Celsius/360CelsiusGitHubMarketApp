package com.a360.celsius.stocksalmanac;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.a360.celsius.stocksalmanac.datamodel.SideMenuItemDataModel;
import com.a360.celsius.stocksalmanac.listadapter.SideMenuListCustomAdapter;
import com.a360.celsius.stocksalmanac.recivers.BroadCastReciver;
import com.a360.celsius.stocksalmanac.service.StockDataPullService;
import com.a360.celsius.stocksalmanac.service.StockDataPullServiceIntentKeys;

import java.util.ArrayList;

public class LiveActivity extends BaseActivity {


    private BroadCastReciver receiver;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private RelativeLayout mainView;
    private Toolbar toolbar;

    private ArrayList<SideMenuItemDataModel> dataModels;
    private ListView listView;
    private View sideMenuShadow;
    private RelativeLayout mainViewl;


    private static SideMenuListCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mainView = (RelativeLayout) findViewById(R.id.main_view);
        sideMenuShadow = (View) findViewById(R.id.shadow);
        mainView = (RelativeLayout) findViewById(R.id.main_view);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name){

            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainView.setTranslationX(slideOffset * drawerView.getWidth());
                toolbar.setTranslationX(slideOffset * drawerView.getWidth());
                drawerLayout.bringChildToFront(drawerView);
                drawerLayout.requestLayout();
                drawerLayout.setScrimColor(Color.TRANSPARENT);
            }
        };



        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        //toolbar.setLogo(R.drawable.logo);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);



        listView=(ListView)findViewById(R.id.side_menu_list);

        dataModels= new ArrayList<>();

        dataModels= new ArrayList<>();

        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_financials), R.drawable.financials,getResources().getColor(R.color.sliding_menu_financials_bg),1));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_goods), R.drawable.goods,getResources().getColor(R.color.sliding_menu_goods_bg),2));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_healthcare), R.drawable.healthcare,getResources().getColor(R.color.sliding_menu_healthcare_bg),3));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_industrial), R.drawable.industrial,getResources().getColor(R.color.sliding_menu_industrial_bg),4));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_materials), R.drawable.materials,getResources().getColor(R.color.sliding_menu_materials_bg),5));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_oilandgas), R.drawable.oilandgas,getResources().getColor(R.color.sliding_menu_oilandgas_bg),6));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_services), R.drawable.services,getResources().getColor(R.color.sliding_menu_services_bg),7));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_technology), R.drawable.technology,getResources().getColor(R.color.sliding_menu_technology_bg),8));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_utilities), R.drawable.utilities,getResources().getColor(R.color.sliding_menu_utilities_bg),9));

        adapter= new SideMenuListCustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SideMenuItemDataModel dataModel= dataModels.get(position);
                setSideMenuSeperatorColor(dataModel);
                sendServiceRequestBySelectedCategory(dataModel);
                //setMainViewColor(dataModel);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter(StockDataPullService.GET_QOUTES_DATA);
        receiver = new BroadCastReciver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }

    private void sendServiceRequestBySelectedCategory(SideMenuItemDataModel dataModel) {

        Intent msgIntent = new Intent(getApplicationContext(), StockDataPullService.class);
        switch (dataModel.getCategoryID()){
            case 1:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_FINANCIALS_KEY);
                startService(msgIntent);
                break;
            case 2:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_GOODS_KEY);
                startService(msgIntent);
                break;
            case 3:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_HEALTHCARE_KEY);
                startService(msgIntent);
                break;
            case 4:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_INDUSTRIAL_KEY);
                startService(msgIntent);
                break;
            case 5:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_MATERIAL_KEY);
                startService(msgIntent);
                break;
            case 6:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_OILANDGAS_KEY);
                startService(msgIntent);
                break;
            case 7:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_SERVICES_KEY);
                startService(msgIntent);
                break;
            case 8:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_TECHNOLOGY_KEY);
                startService(msgIntent);
                break;
            case 9:
                msgIntent.putExtra(StockDataPullServiceIntentKeys.DATA_TYPE_KEY, StockDataPullServiceIntentKeys.DATA_TYPE_UTILITIES_KEY);
                startService(msgIntent);
                break;

        }
    }

    private void setMainViewColor(SideMenuItemDataModel dataModel) {
        mainView.setBackgroundColor(dataModel.getColor());
    }

    private void setSideMenuSeperatorColor(SideMenuItemDataModel dataModel) {
        sideMenuShadow.setBackgroundColor(dataModel.getColor());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in androidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
