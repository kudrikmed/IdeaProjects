package com.aide.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ÑÂÊ on 17.12.2016.
 */
public class DashboardActivity extends Activity {
    public static final String APP_PREFERENCES = "mysettings";

    SharedPreferences mSettings;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        Button btnAries = (Button) findViewById(R.id.zodiac);
        btnAries.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intentDashboard = new Intent(DashboardActivity.this, TabWesternActivity.class);
                startActivity(intentDashboard);


            }
        });

        Button btnTaurus = (Button) findViewById(R.id.easternhoro);
        btnTaurus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent intentDashboardFood = new Intent(DashboardActivity.this, TabEasternActivity.class);
                startActivity(intentDashboardFood);

            }
        });

        Button btnGemini = (Button) findViewById(R.id.celtic);
        btnGemini.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent intentDashboardSport = new Intent(DashboardActivity.this, TabCelticActivity.class);
                startActivity(intentDashboardSport);

            }
        });

        Button btnCancer = (Button) findViewById(R.id.druids);
        btnCancer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {


                Intent intentDashboardMusic = new Intent(DashboardActivity.this, TabDruidsActivity.class);
                startActivity(intentDashboardMusic);

            }
        });
    }
}