package com.horo.horoscopeastro;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appodeal.ads.Appodeal;
import com.google.android.gms.ads.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ÑÂÊ on 26.08.2015.
 */
public class NumbersActivity extends Activity {
    public static final String APP_PREFERENCES = "mysettings";
    private ArcProgress healthProgress;
    private ArcProgress loveProgress;
    private ArcProgress fortuneProgress;
    private ArcProgress careerProgress;
    private ArcProgress familyProgress;
    private ArcProgress friendsProgress;
    SharedPreferences mSettings;
    AdView mAdView;
    private InterstitialAd interstitial;

    private final String TAPPX_KEY = "/120940746/Pub-5704-Android-9968";
    private com.google.android.gms.ads.doubleclick.PublisherAdView adBanner = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.numbers_layout);
    //    adBanner = com.tappx.TAPPXAdBanner.ConfigureAndShowAtBottom(this, adBanner, TAPPX_KEY);

        /*
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-5186877757924020/8944865590");

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relatenumber);
        RelativeLayout.LayoutParams rLParams =
                new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rLParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
        relativeLayout.addView(mAdView, rLParams);

        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);
        */

        String appKey = "0ca5f2b19a274d3833009ed23bf7ffbe0a667ecf695b9850";          // change

        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL);




        interstitial = new InterstitialAd(NumbersActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId("ca-app-pub-5186877757924020/5743812790");
        AdRequest adRequest = new AdRequest.Builder().build();
        // Load ads into Interstitial Ads
    //    interstitial.loadAd(adRequest);

        // Prepare an Interstitial Ad Listener

        /*
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {

                displayInterstitial();
            }
        });
        */
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        // Sender sender = new Sender(mSettings.getString("sign", "aries"), getString(R.string.server_ip_today, mSettings.getString("language","eng")));
        Sender sender = new Sender(mSettings.getString("sign", "aries"), getString(R.string.server_ip_numbers), getString(R.string.language));

        try {
            JSONObject foodFirstDayJSON = sender.Execute();


            ArcProgress archealth =  (ArcProgress) findViewById(R.id.health);
            archealth.setProgress(Integer.parseInt(foodFirstDayJSON.getString("random1")));

            ArcProgress arclove =  (ArcProgress) findViewById(R.id.love);
            arclove.setProgress(Integer.parseInt(foodFirstDayJSON.getString("random2")));

            ArcProgress arccareer =  (ArcProgress) findViewById(R.id.career);
            arccareer.setProgress(Integer.parseInt(foodFirstDayJSON.getString("random3")));

            ArcProgress arcfortune =  (ArcProgress) findViewById(R.id.fortune);
            arcfortune.setProgress(Integer.parseInt(foodFirstDayJSON.getString("random4")));

            ArcProgress arcfamily =  (ArcProgress) findViewById(R.id.family);
            arcfamily.setProgress(Integer.parseInt(foodFirstDayJSON.getString("random5")));

            ArcProgress arcfriends =  (ArcProgress) findViewById(R.id.friends);
            arcfriends.setProgress(Integer.parseInt(foodFirstDayJSON.getString("random6")));

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        healthProgress = (ArcProgress) findViewById(R.id.health);
        healthProgress.setBottomText(getString(R.string.health));
        healthProgress.setUnfinishedStrokeColor(getResources().getColor(R.color.blue));
        healthProgress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
        healthProgress.setTextColor(getResources().getColor(R.color.white));
        healthProgress.setStrokeWidth(20);

        loveProgress = (ArcProgress) findViewById(R.id.love);
        loveProgress.setBottomText(getString(R.string.love));
        loveProgress.setUnfinishedStrokeColor(getResources().getColor(R.color.blue));
        loveProgress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
        loveProgress.setTextColor(getResources().getColor(R.color.white));
        loveProgress.setStrokeWidth(20);

        fortuneProgress = (ArcProgress) findViewById(R.id.fortune);
        fortuneProgress.setBottomText(getString(R.string.fortune));
        fortuneProgress.setUnfinishedStrokeColor(getResources().getColor(R.color.blue));
        fortuneProgress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
        fortuneProgress.setTextColor(getResources().getColor(R.color.white));
        fortuneProgress.setStrokeWidth(20);

        careerProgress = (ArcProgress) findViewById(R.id.career);
        careerProgress.setBottomText(getString(R.string.career));
        careerProgress.setUnfinishedStrokeColor(getResources().getColor(R.color.blue));
        careerProgress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
        careerProgress.setTextColor(getResources().getColor(R.color.white));
        careerProgress.setStrokeWidth(20);

        familyProgress = (ArcProgress) findViewById(R.id.family);
        familyProgress.setBottomText(getString(R.string.family));
        familyProgress.setUnfinishedStrokeColor(getResources().getColor(R.color.blue));
        familyProgress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
        familyProgress.setTextColor(getResources().getColor(R.color.white));
        familyProgress.setStrokeWidth(20);

        friendsProgress = (ArcProgress) findViewById(R.id.friends);
        friendsProgress.setBottomText(getString(R.string.friends));
        friendsProgress.setUnfinishedStrokeColor(getResources().getColor(R.color.blue));
        friendsProgress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
        friendsProgress.setTextColor(getResources().getColor(R.color.white));
        friendsProgress.setStrokeWidth(20);


    }
    @Override
    protected void onResume() {
        super.onResume();
     /*   interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
*/
    }
    @Override
    protected void onPause() {
        super.onPause();

        if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        }
    }
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}