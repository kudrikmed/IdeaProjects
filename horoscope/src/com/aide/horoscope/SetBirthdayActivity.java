package com.aide.horoscope;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by ÑÂÊ on 17.12.2016.
 */
public class SetBirthdayActivity extends Activity {

    private DatePicker mDatePicker;
    private int chinesesign;
    private int iMonth;
    private int iDay;
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences mSettings;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setbirthday);
        context = this;

        mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        Calendar today = Calendar.getInstance();


        Button changingDateButton = (Button) findViewById(R.id.button);
        changingDateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                chinesesign = mDatePicker.getYear() - (int) (mDatePicker.getYear()/12)*12;
                iMonth = mDatePicker.getMonth();
                iDay = mDatePicker.getDayOfMonth();

switch (chinesesign)
{
    case 0:
        mSettings.edit().putString("chinesesign", "monkey").apply();
    //    Toast.makeText(getApplicationContext(), String.valueOf(chinesesign), Toast.LENGTH_SHORT).show();
        break;
    case 1:
        mSettings.edit().putString("chinesesign", "rooster").apply();

        break;
    case 2:
        mSettings.edit().putString("chinesesign", "dog").apply();

        break;
    case 3:
        mSettings.edit().putString("chinesesign", "pig").apply();
        break;
    case 4:
        mSettings.edit().putString("chinesesign", "rat").apply();
        break;
    case 5:
        mSettings.edit().putString("chinesesign", "ox").apply();
        break;
    case 6:
        mSettings.edit().putString("chinesesign", "tiger").apply();
        break;
    case 7:
        mSettings.edit().putString("chinesesign", "rabbit").apply();
        break;
    case 8:
        mSettings.edit().putString("chinesesign", "dragon").apply();
        break;
    case 9:
        mSettings.edit().putString("chinesesign", "snake").apply();

        break;
    case 10:
        mSettings.edit().putString("chinesesign", "horse").apply();
        break;
    case 11:
        mSettings.edit().putString("chinesesign", "goat").apply();
        break;
}
                switch (iMonth) {
                    case 11:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "capricorn").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "sagittarius").apply();
                            break;
                        }
                    case 10:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "sagittarius").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "scorpio").apply();
                       //     Toast.makeText(getApplicationContext(), "scorpio", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    case 9:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "scorpio").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "libra").apply();
                            break;
                        }
                    case 8:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "libra").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "virgo").apply();
                            break;
                        }
                    case 7:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "virgo").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "leo").apply();
                            break;
                        }
                    case 6:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "leo").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "cancer").apply();
                            break;
                        }
                    case 5:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "cancer").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "gemini").apply();
                            break;
                        }
                    case 4:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "gemini").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "taurus").apply();
                            break;
                        }
                    case 3:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "taurus").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "aries").apply();
                            break;
                        }
                    case 2:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "aries").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "pisces").apply();
                            break;
                        }
                    case 1:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "pisces").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "aquarius").apply();
                            break;
                        }
                    case 0:
                        if (iDay >= 22)
                        {
                            mSettings.edit().putString("westernsign", "aquarius").apply();
                            break;
                        }
                        else
                        {
                            mSettings.edit().putString("westernsign", "capricorn").apply();
                            break;
                        }
                }
                Intent intentDashboardFood = new Intent(SetBirthdayActivity.this, DashboardActivity.class);
                startActivity(intentDashboardFood);
                finish();

            }
        });
}
}