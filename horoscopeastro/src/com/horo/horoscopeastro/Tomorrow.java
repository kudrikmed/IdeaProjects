package com.horo.horoscopeastro;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.*;
import com.startad.lib.SADView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by СВК on 21.05.2015.
 */
public class Tomorrow extends Activity {
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences mSettings;
    protected SADView sadView;
    AdView mAdView;
    private InterstitialAd interstitial;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tomorrow);
/*
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Try Android Yorshik!");

        */
     //   startActivity(Intent.createChooser(intent, getString(R.string.app_name)));

/*
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-5186877757924020/3697632791");



        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relatedlong);
        RelativeLayout.LayoutParams rLParams =
                new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rLParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
        relativeLayout.addView(mAdView, rLParams);

        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);
*/


        /*
        interstitial = new InterstitialAd(Tomorrow.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId("ca-app-pub-5186877757924020/5604211992");
        AdRequest adRequest = new AdRequest.Builder().build();
        // Load ads into Interstitial Ads
        interstitial.loadAd(adRequest);

        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
*/

        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
      //  Sender sender = new Sender(mSettings.getString("sign", "aries"), getString(R.string.server_ip_tomorrow));
        Sender sender = new Sender(mSettings.getString("sign", "aries"), getString(R.string.server_ip_tomorrow), getString(R.string.language));

        try {
            JSONObject foodFirstDayJSON = sender.Execute();

            TextView name = (TextView) findViewById(R.id.tomorrowtext);
            name.setText(foodFirstDayJSON.getString(mSettings.getString("sign", "aries")));


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}