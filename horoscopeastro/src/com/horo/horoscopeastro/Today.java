package com.horo.horoscopeastro;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;
import com.google.android.gms.ads.*;
import com.startad.lib.SADView;
import org.json.JSONException;
import org.json.JSONObject;

public class Today extends Activity {
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences mSettings;
    protected SADView sadView;
    private InterstitialAd interstitial;
   Context context;
   int repet = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today);
        context = this;


     //   Appodeal.setTesting(true);


        this.sadView = new SADView(this, "555d3099e84c0f2600000000");
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.relatedshort);
        RelativeLayout.LayoutParams rLParams =
                new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rLParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
        layout.addView(this.sadView, rLParams);
        if (getString(R.string.language).equals("rus")) {
            this.sadView.loadAd(SADView.LANGUAGE_RU);
        }
        else
        {
            this.sadView.loadAd(SADView.LANGUAGE_EN);
        }

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
        Sender sender = new Sender(mSettings.getString("sign", "aries"), getString(R.string.server_ip_today), getString(R.string.language));


        try {
            JSONObject foodFirstDayJSON = sender.Execute();

            TextView name = (TextView) findViewById(R.id.todayhoro);
            name.setText(foodFirstDayJSON.getString(mSettings.getString("sign", "aries")));


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }



        /*
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
*/


    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }


    }
}