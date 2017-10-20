package com.a360.celsius.stocksalmanac;


import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a360.celsius.stocksalmanac.datamodel.SideMenuItemDataModel;
import com.a360.celsius.stocksalmanac.listadapter.SideMenuListCustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    RelativeLayout mainView;
    Toolbar toolbar;

    ArrayList<SideMenuItemDataModel> dataModels;
    ListView listView;


    private static SideMenuListCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mainView = (RelativeLayout) findViewById(R.id.mainView);
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

        dataModels.add(new SideMenuItemDataModel("Financials", R.drawable.financials));
        dataModels.add(new SideMenuItemDataModel("Goods", R.drawable.goods));
        dataModels.add(new SideMenuItemDataModel("Health Care", R.drawable.healthcare));
        dataModels.add(new SideMenuItemDataModel("Industrial", R.drawable.industrial));
        dataModels.add(new SideMenuItemDataModel("Materials", R.drawable.materials));
        dataModels.add(new SideMenuItemDataModel("Oil & Gas", R.drawable.oilandgas));
        dataModels.add(new SideMenuItemDataModel("Services", R.drawable.services));
        dataModels.add(new SideMenuItemDataModel("Technology", R.drawable.technology));
        dataModels.add(new SideMenuItemDataModel("Utilities", R.drawable.utilities));

        adapter= new SideMenuListCustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SideMenuItemDataModel dataModel= dataModels.get(position);

            }
        });

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
