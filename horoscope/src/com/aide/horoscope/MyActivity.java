package com.aide.horoscope;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_FIRST_START_DATE = "first_day";
    public static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_REG_ID = "registration_id";
    public static final String TAG = "GCM";

    SharedPreferences mSettings;
    public String regid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        long firstStart = mSettings.getLong(APP_FIRST_START_DATE, 0);
        if (firstStart == 0) {

            Context context = MyActivity.this;


            mSettings.edit().putLong(APP_FIRST_START_DATE, 1).apply();
            Intent intentDashboard = new Intent(MyActivity.this, SetBirthdayActivity.class);
            startActivity(intentDashboard);

            finish();
        } else {

            Intent intentDashboard = new Intent(MyActivity.this, DashboardActivity.class);
            startActivity(intentDashboard);
            finish();




        }
    }
}
