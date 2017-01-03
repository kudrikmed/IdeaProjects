package com.horo.horoscopeastro;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import com.flurry.android.FlurryAgent;

/**
 * Created by СВК on 21.05.2015.
 */
public class TabActivity extends android.app.TabActivity {
    public static final String APP_PREFERENCES = "mysettings";
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabactivity);

        SharedPreferences mSettings;
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        String sign = mSettings.getString("sign", "aries");

        FlurryAgent.setLogEnabled(false);
        FlurryAgent.init(this, "P4Y2MZQ6BX9GQN4JF4BB");

        getActionBar().setTitle(Html.fromHtml("<font color='#fcbd1f'>" + getString(getStringResourceByName(sign)) + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getActionBar().setIcon(getResources().getDrawable(getDrawResourceByName(sign)));
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;


        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator(getString(R.string.diagram));
        tabSpec.setContent(new Intent(this, NumbersActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator(getString(R.string.today));
        tabSpec.setContent(new Intent(this, Today.class));
        tabHost.addTab(tabSpec);







        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setIndicator(getString(R.string.tomorrow));
        tabSpec.setContent(new Intent(this, Tomorrow.class));
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
                Intent intentSetSign = new Intent(TabActivity.this, SettingsActivity.class);
                startActivity(intentSetSign);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);}}
}
