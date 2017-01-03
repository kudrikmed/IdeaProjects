package com.aide.horoscope;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ÑÂÊ on 17.12.2016.
 */
public class WesternToday extends Activity {
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences mSettings;

    Context context;
    int repet = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.westerntoday);
        context = this;


        //   Appodeal.setTesting(true);



        // admob ads
      /*
        interstitial = new InterstitialAd(Today.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId("ca-app-pub-5186877757924020/1561199598");
        AdRequest adRequest = new AdRequest.Builder().build();
        // Load ads into Interstitial Ads
        interstitial.loadAd(adRequest);

        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
             //   displayInterstitial();


            }
        });

        */


        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        // Sender sender = new Sender(mSettings.getString("sign", "aries"), getString(R.string.server_ip_today, mSettings.getString("language","eng")));
        Sender sender = new Sender(mSettings.getString("westernsign", "aries"), getString(R.string.server_ip_today), getString(R.string.language));


        TextView sign = (TextView) findViewById(R.id.sign);
        sign.setText(mSettings.getString("westernsign", "aries"));

        try {
            JSONObject foodFirstDayJSON = sender.Execute();

            TextView name = (TextView) findViewById(R.id.todayhoro);
            name.setText(foodFirstDayJSON.getString(mSettings.getString("westernsign", "aries")));


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}