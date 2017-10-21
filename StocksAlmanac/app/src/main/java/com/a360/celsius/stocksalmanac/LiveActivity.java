package com.a360.celsius.stocksalmanac;


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

import java.util.ArrayList;

public class LiveActivity extends BaseActivity {



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

        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_financials), R.drawable.financials,getResources().getColor(R.color.sliding_menu_financials_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_goods), R.drawable.goods,getResources().getColor(R.color.sliding_menu_goods_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_healthcare), R.drawable.healthcare,getResources().getColor(R.color.sliding_menu_healthcare_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_industrial), R.drawable.industrial,getResources().getColor(R.color.sliding_menu_industrial_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_materials), R.drawable.materials,getResources().getColor(R.color.sliding_menu_materials_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_oilandgas), R.drawable.oilandgas,getResources().getColor(R.color.sliding_menu_oilandgas_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_services), R.drawable.services,getResources().getColor(R.color.sliding_menu_services_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_technology), R.drawable.technology,getResources().getColor(R.color.sliding_menu_technology_bg)));
        dataModels.add(new SideMenuItemDataModel(getResources().getString(R.string.side_menu_utilities), R.drawable.utilities,getResources().getColor(R.color.sliding_menu_utilities_bg)));

        adapter= new SideMenuListCustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SideMenuItemDataModel dataModel= dataModels.get(position);
                setSideMenuSeperatorColor(dataModel);
                setMainViewColor(dataModel);

            }
        });

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
