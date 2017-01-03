package com.smartmedsoftdevelopment.profit;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    SharedPreferences mSettings;
    Context context;

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "days_before_use";
    public static final String APP_FIRST_START_DATE = "first_day";

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static final String EXTRA_MESSAGE = "message";
    public static final String PROPERTY_REG_ID = "registration_id";
    public static final String PROPERTY_APP_VERSION = "appVersion";
    private static final String TAG = "GCMRelated";
    GoogleCloudMessaging gcm;
    AtomicInteger msgId = new AtomicInteger();
    public String regid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE); // sharedPreferences
        context = MyActivity.this;
        long firstStart = mSettings.getLong(APP_FIRST_START_DATE, 0);




        if (firstStart == 0) {
            //the app is being launched for first time, do something


            Calendar today = Calendar.getInstance();
            today.set(Calendar.MILLISECOND, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.HOUR_OF_DAY, 0);
            mSettings.edit().putLong(APP_FIRST_START_DATE, today.getTimeInMillis() / (1000 * 60 * 60 * 24)).apply(); //?????????? ???? ??????? ???????

            gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
            new RegisterApp(getApplicationContext(), gcm, getAppVersion(getApplicationContext())).execute();
            regid = getRegistrationId(getApplicationContext());

            Intent intentDashboard = new Intent(MyActivity.this, DashboardActivity.class);
            startActivity(intentDashboard);
            handleNotification();
            finish();


        }


        else {

            Intent intentDashboard = new Intent(MyActivity.this, DashboardActivity.class);
            startActivity(intentDashboard);
            handleNotification();
            finish();


        }


    }

    private SharedPreferences getGCMPreferences(Context context) {
        // This sample app persists the registration ID in shared preferences, but
        // how you store the regID in your app is up to you.
        return getSharedPreferences(MyActivity.class.getSimpleName(),
                Context.MODE_PRIVATE);
    }

    private static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public String getRegistrationId(Context context) {
        final SharedPreferences prefs = getGCMPreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(getApplicationContext());
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "App version changed.");
            return "";
        }
        return registrationId;
    }

    private void handleNotification() {
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //  alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5000, pendingIntent);
        Calendar c = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, 8); // For 1 PM or 2 PM
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}
