package com.smartmedsoftdevelopment.profit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
// import com.flurry.android.FlurryAgent;

public class DashboardActivity extends Activity {


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   this.requestWindowFeature(Window.FEATURE_NO_TITLE);  // actionbar on dashboard layout

        getActionBar().setTitle(Html.fromHtml("<font color='#fcbd1f'>" + "ProFit" + "</font>"));
      //  getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33b5e5")));
        setContentView(R.layout.dashboard_layout);
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        final Context mContext = this;
        final Vibrator vibe = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);

/*
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.init(this, "FMFD2G3V7K7N3FRYR4HS");

*/
        Button btnNewMessage = (Button) findViewById(R.id.home_btn_new_message);
        btnNewMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                vibe.vibrate(50);
                Intent intentDashboard = new Intent(DashboardActivity.this, TabPullActivity.class);
                startActivity(intentDashboard);

            }
        });

        Button btnFood = (Button) findViewById(R.id.home_btn_messages);
        btnFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                vibe.vibrate(50);
                Intent intentDashboardFood = new Intent(DashboardActivity.this, TabPushActivity.class);
                startActivity(intentDashboardFood);

            }
        });

        Button btnSport = (Button) findViewById(R.id.home_btn_preferences);
        btnSport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                vibe.vibrate(50);
                Intent intentDashboardSport = new Intent(DashboardActivity.this, TabSitActivity.class);
                startActivity(intentDashboardSport);
            }
        });

        Button btnMusic = (Button) findViewById(R.id.home_btn_music);
        btnMusic.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                vibe.vibrate(50);
                Intent intentDashboardMusic = new Intent(DashboardActivity.this, TabSquatActivity.class);
                startActivity(intentDashboardMusic);
            }
        });

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_tab_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.languageChange:
                Intent intentSetLanguage = new Intent(DashboardActivity.this, LanguageSelectActivity.class);
                startActivity(intentSetLanguage);
                return true;
            case R.id.DateChange:
                Intent intentSetGestation = new Intent(DashboardActivity.this, DialogDateActivity.class);
                startActivity(intentSetGestation);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}
