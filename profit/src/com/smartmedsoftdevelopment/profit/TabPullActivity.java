package com.smartmedsoftdevelopment.profit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import java.io.IOException;

/**
 * Created by ÑÂÊ on 12.07.2016.
 */
public class TabPullActivity extends android.app.TabActivity {
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences pref;


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabactivity);
        DataHelper mDbHelper = new DataHelper(this);
        pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        try {
            mDbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }


        mDbHelper.openDataBase();
        SQLiteDatabase sdb;
        sdb = mDbHelper.getReadableDatabase();


        Cursor cursor = sdb.query("pullups",
                null,
                "_id = " + pref.getInt("PULL_WORKOUT_NUMBER", 1), null,
                null, null, null);

        cursor.moveToFirst();
        String title = getResources().getString(R.string.week) + " " + cursor.getString(cursor.getColumnIndex("week")) + " " +
                getResources().getString(R.string.day) + " " + cursor.getString(cursor.getColumnIndex("day")) + " - " + getResources().getString(R.string.btn_pullup);

        getActionBar().setTitle(Html.fromHtml("<font color='#fcbd1f'>" + title + "</font>"));
        //   getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.gold)));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        //  getActionBar().setIcon(getResources().getDrawable(getDrawResourceByName(sign)));
        mDbHelper.close();

/*
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.init(this, "P4Y2MZQ6BX9GQN4JF4BB");
*/
   /*
        getActionBar().setTitle(Html.fromHtml("<font color='#fcbd1f'>" + getString(getStringResourceByName(sign)) + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getActionBar().setIcon(getResources().getDrawable(getDrawResourceByName(sign)));
   */
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;


        tabSpec = tabHost.newTabSpec("tag1");
        //   tabSpec.setIndicator(getString(R.string.diagram));
        tabSpec.setIndicator(getString(R.string.workout));

        tabSpec.setContent(new Intent(this, PullWorkout.class));
        tabHost.addTab(tabSpec);


        tabSpec = tabHost.newTabSpec("tag2");
        //  tabSpec.setIndicator(getString(R.string.today));
        tabSpec.setIndicator(getString(R.string.statistics));
        tabSpec.setContent(new Intent(this, PullupStatistics.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        //  tabSpec.setIndicator(getString(R.string.today));
        tabSpec.setIndicator(getString(R.string.chart));
        tabSpec.setContent(new Intent(this, ChartPullActivity.class));
        tabHost.addTab(tabSpec);


    }
    private int getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return resId;
    }

    private int getDrawResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "drawable", packageName);
        return resId;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tab_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.signChange:
                Intent intentSetSign = new Intent(TabPullActivity.this, DateSelectorPull.class);
                startActivity(intentSetSign);
              //  finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);}}

}
