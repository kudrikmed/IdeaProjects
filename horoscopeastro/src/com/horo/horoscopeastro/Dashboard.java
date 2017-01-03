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
 * Created by СВК on 21.05.2015.
 */
public class Dashboard extends Activity {
    public static final String APP_PREFERENCES = "mysettings";

    SharedPreferences mSettings;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>" + getString(R.string.choosesign) + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        Button btnAries = (Button) findViewById(R.id.aries);
        btnAries.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "aries").apply();
                Intent intentDashboard = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboard);
                finish();

            }
        });

        Button btnTaurus = (Button) findViewById(R.id.taurus);
        btnTaurus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "taurus").apply();
                Intent intentDashboardFood = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardFood);
                finish();
            }
        });

        Button btnGemini = (Button) findViewById(R.id.gemini);
        btnGemini.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "gemini").apply();
                Intent intentDashboardSport = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardSport);
                finish();
            }
        });

        Button btnCancer = (Button) findViewById(R.id.cancer);
        btnCancer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "cancer").apply();
                Intent intentDashboardMusic = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardMusic);
                finish();
            }
        });

        Button btnLeo = (Button) findViewById(R.id.leo);
        btnLeo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "leo").apply();
                Intent intentDashboardAsk = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardAsk);
                finish();


            }
        });

        Button btnVirgo = (Button) findViewById(R.id.virgo);
        btnVirgo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "virgo").apply();
                Intent intentDashboardFacility = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardFacility);
                finish();
            }
        });
        Button btnLibra = (Button) findViewById(R.id.libra);
        btnLibra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                mSettings.edit().putString("sign", "libra").apply();
                Intent intentDashboard = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboard);
                finish();

            }
        });

        Button btnScorpius = (Button) findViewById(R.id.scorpius);
        btnScorpius.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "scorpio").apply();
                Intent intentDashboardFood = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardFood);
                finish();

            }
        });

        Button btnSagittarius = (Button) findViewById(R.id.sagittarius);
        btnSagittarius.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "sagittarius").apply();
                Intent intentDashboardSport = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardSport);
                finish();
            }
        });

        Button btnCapricorn = (Button) findViewById(R.id.capricorn);
        btnCapricorn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "capricorn").apply();
                Intent intentDashboardMusic = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardMusic);
                finish();
            }
        });

        Button btnAquarius = (Button) findViewById(R.id.aquarius);
        btnAquarius.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "aquarius").apply();
                Intent intentDashboardAsk = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardAsk);
                finish();


            }
        });

        Button btnPisces = (Button) findViewById(R.id.pisces);
        btnPisces.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                mSettings.edit().putString("sign", "pisces").apply();
                Intent intentDashboardFacility = new Intent(Dashboard.this, TabActivity.class);
                startActivity(intentDashboardFacility);
                finish();
            }
        });
    }
}