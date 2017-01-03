package com.horo.horoscopeastro;


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

import android.view.View;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Pattern;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     * http://www.findyourfate.com/rss/horoscope-feed.asp
     */
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_FIRST_START_DATE = "first_day";
    public static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_REG_ID = "registration_id";
    public static final String TAG = "GCM";

    SharedPreferences mSettings;
    GoogleCloudMessaging gcm;
    public String regid;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        handleNotification();
        long firstStart = mSettings.getLong(APP_FIRST_START_DATE, 0);
        if (firstStart == 0) {

            Context context = MyActivity.this;
            gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
            new RegisterApp(getApplicationContext(), gcm, getAppVersion(getApplicationContext()), context.getResources().getString(R.string.language)).execute();
            regid = getRegistrationId(getApplicationContext());



            mSettings.edit().putLong(APP_FIRST_START_DATE, 1).apply();
            Intent intentDashboard = new Intent(MyActivity.this, Dashboard.class);
            startActivity(intentDashboard);

            finish();
        } else {

            Intent intentDashboard = new Intent(MyActivity.this, TabActivity.class);
            startActivity(intentDashboard);
            finish();




        }



    }

    private String getRegistrationId(Context context) {
        final SharedPreferences prefs = getGCMPreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing registration ID is not guaranteed to work with
        // the new app version.
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "App version changed.");
            return "";
        }
        return registrationId;
    }

    private SharedPreferences getGCMPreferences(Context context) {
        // This sample app persists the registration ID in shared preferences, but
        // how you store the registration ID in your app is up to you.
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

    public void register() {

        Context context = MyActivity.this;
        String possibleEmail = null;
        String language = context.getResources().getString(R.string.language);
        final SharedPreferences prefs = getSharedPreferences(MyActivity.class.getSimpleName(),
                Context.MODE_PRIVATE);
        String registrationId = prefs.getString(MyActivity.PROPERTY_REG_ID, "");
     /*   Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        Account[] accounts = AccountManager.get(context).getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                possibleEmail = account.name;
            }
        }
*/
        HashMap<String, String> registrationPackage = new HashMap<String, String>();
        registrationPackage.put("registrationID", registrationId);
        registrationPackage.put("email", possibleEmail);
        registrationPackage.put("language", language);

        AsyncHttpPost asyncHttpPostRegistration = new AsyncHttpPost(registrationPackage);
        asyncHttpPostRegistration.execute("http://pregnant.by/horo/registerUserToDatabase.php");
    }


    private void handleNotification() {
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
      //  alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5000, pendingIntent);
        Calendar c = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, 6); // For 1 PM or 2 PM
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);


    }

}