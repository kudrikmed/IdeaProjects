package com.horo.horoscopeastro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

/**
 * Created by ÑÂÊ on 26.08.2015.
 */
public class SettingsActivity extends Activity {
    public static final String APP_PREFERENCES = "mysettings";

    SharedPreferences mSettings;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>" + getString(R.string.settings) + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        Button btnSign = (Button) findViewById(R.id.language);
        btnSign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intentDashboard = new Intent(SettingsActivity.this, LanguageActivity.class);
                startActivity(intentDashboard);
                finish();

            }
        });

        Button btnLanguage = (Button) findViewById(R.id.sign);
        btnLanguage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            //    mSettings.edit().putString("sign", "taurus").apply();
                Intent intentDashboardFood = new Intent(SettingsActivity.this, Dashboard.class);
                startActivity(intentDashboardFood);
                finish();
            }
        });


    }
}