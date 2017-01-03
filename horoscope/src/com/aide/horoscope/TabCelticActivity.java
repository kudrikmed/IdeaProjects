package com.aide.horoscope;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

/**
 * Created by ÑÂÊ on 17.12.2016.
 */
public class TabCelticActivity extends android.app.TabActivity {
    public static final String APP_PREFERENCES = "mysettings";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tabactivity);
        SharedPreferences mSettings;
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        String chinesesign = mSettings.getString("chinesesign", "monkey");
        String westernsign = mSettings.getString("westernsign", "capricorn");

        //   getActionBar().setTitle(Html.fromHtml("<font color='#fcbd1f'>" + getString(getStringResourceByName(westernsign)) + "</font>"));
        // getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        //  getActionBar().setIcon(getResources().getDrawable(getDrawResourceByName(sign)));
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;


        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator(getString(R.string.today));
        tabSpec.setContent(new Intent(this, CelticToday.class));
        tabHost.addTab(tabSpec);


        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator(getString(R.string.tomorrow));
        tabSpec.setContent(new Intent(this, CelticTomorrow.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setIndicator(getString(R.string.numbers));
        tabSpec.setContent(new Intent(this, NumberActivity.class));
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
                Intent intentSetSign = new Intent(TabCelticActivity.this, SettingsActivity.class);
                startActivity(intentSetSign);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);}}
}

