package com.aide.horoscope;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

/**
 * Created by ÑÂÊ on 26.08.2015.
 */
public class LanguageActivity extends Activity {
    public static final String APP_PREFERENCES = "mysettings";

    SharedPreferences mSettings;
    Locale myLocale;
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>" + getString(R.string.chooselanguage) + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        Button btnEng = (Button) findViewById(R.id.english);
        btnEng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("en");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });
        Button btnUsa = (Button) findViewById(R.id.american);
        btnUsa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("en-US");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });

        Button btnRus = (Button) findViewById(R.id.russian);
        btnRus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("ru");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });
        Button btnDeutch = (Button) findViewById(R.id.deutch);
        btnDeutch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("de");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });
        Button btnEspaniol = (Button) findViewById(R.id.spanish);
        btnEspaniol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("es");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });
        Button btnFrench = (Button) findViewById(R.id.french);
        btnFrench.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("fr");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });

        Button btnChinese = (Button) findViewById(R.id.chinese);
        btnChinese.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("zh");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });
        Button btnJapanese = (Button) findViewById(R.id.japanese);
        btnJapanese.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                setLocale("ja");
                Context context = LanguageActivity.this;
                Intent refresh = new Intent(context, DashboardActivity.class);
                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(refresh);

                finish();

            }
        });
    }
    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);


        Intent refresh = new Intent(this, TabWesternActivity.class);
        refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(refresh);
        finish();

    }
}