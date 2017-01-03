package com.smartmedsoftdevelopment.profit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by ÑÂÊ on 13.07.2016.
 */
public class DateSelectorPush extends Activity {

    RadioGroup weekRadioGroup, dayRadioGroup;
    RadioButton week1, week2, week3, week4, week5, week6, week7, week8, week9, week10, week11, week12, week13, week14, week15, week16, week17, week18;
    SharedPreferences pref;
    View.OnClickListener radioListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dateselector);
        pref = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        String pref = "PUSH_WORKOUT_NUMBER";
        radioListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton rb = (RadioButton) view;

                switch (rb.getId())
                {
                    case R.id.radioButtonWeek1:

                        edit.putInt(pref, 1);
                        edit.commit();
                        Intent intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();


                        break;
                    case R.id.radioButtonWeek2:

                        edit.putInt(pref, 2);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek3:

                        edit.putInt(pref, 3);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek4:

                        edit.putInt(pref, 4);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek5:

                        edit.putInt(pref, 5);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();


                        break;
                    case R.id.radioButtonWeek6:

                        edit.putInt(pref, 6);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek7:

                        edit.putInt(pref, 7);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek8:

                        edit.putInt(pref, 8);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek9:

                        edit.putInt(pref, 9);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek10:

                        edit.putInt(pref, 10);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;

                    case R.id.radioButtonWeek11:

                        edit.putInt(pref, 11);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek12:

                        edit.putInt(pref, 12);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek13:

                        edit.putInt(pref, 13);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();


                        break;
                    case R.id.radioButtonWeek14:

                        edit.putInt(pref, 14);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek15:

                        edit.putInt(pref, 15);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek16:

                        edit.putInt(pref, 16);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;

                    case R.id.radioButtonWeek17:

                        edit.putInt(pref, 17);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                    case R.id.radioButtonWeek18:

                        edit.putInt(pref, 18);
                        edit.commit();
                        intentDashboard = new Intent(DateSelectorPush.this, TabPushActivity.class);
                        startActivity(intentDashboard);
                        finish();
                        break;
                }



            }
        };

        week1 = (RadioButton) findViewById(R.id.radioButtonWeek1);
        week1.setOnClickListener(radioListener);
        week1.setText(getResources().getString(R.string.work1));

        week2 = (RadioButton) findViewById(R.id.radioButtonWeek2);
        week2.setOnClickListener(radioListener);
        week2.setText(getResources().getString(R.string.work2));

        week3 = (RadioButton) findViewById(R.id.radioButtonWeek3);
        week3.setOnClickListener(radioListener);
        week3.setText(getResources().getString(R.string.work3));

        week4 = (RadioButton) findViewById(R.id.radioButtonWeek4);
        week4.setOnClickListener(radioListener);
        week4.setText(getResources().getString(R.string.work4));

        week5 = (RadioButton) findViewById(R.id.radioButtonWeek5);
        week5.setOnClickListener(radioListener);
        week5.setText(getResources().getString(R.string.work5));

        week6 = (RadioButton) findViewById(R.id.radioButtonWeek6);
        week6.setOnClickListener(radioListener);
        week6.setText(getResources().getString(R.string.work6));

        week7 = (RadioButton) findViewById(R.id.radioButtonWeek7);
        week7.setOnClickListener(radioListener);
        week7.setText(getResources().getString(R.string.work7));

        week8 = (RadioButton) findViewById(R.id.radioButtonWeek8);
        week8.setOnClickListener(radioListener);
        week8.setText(getResources().getString(R.string.work8));

        week9 = (RadioButton) findViewById(R.id.radioButtonWeek9);
        week9.setOnClickListener(radioListener);
        week9.setText(getResources().getString(R.string.work9));

        week10 = (RadioButton) findViewById(R.id.radioButtonWeek10);
        week10.setOnClickListener(radioListener);
        week10.setText(getResources().getString(R.string.work10));

        week11 = (RadioButton) findViewById(R.id.radioButtonWeek11);
        week11.setOnClickListener(radioListener);
        week11.setText(getResources().getString(R.string.work11));

        week12 = (RadioButton) findViewById(R.id.radioButtonWeek12);
        week12.setOnClickListener(radioListener);
        week12.setText(getResources().getString(R.string.work12));

        week13 = (RadioButton) findViewById(R.id.radioButtonWeek13);
        week13.setOnClickListener(radioListener);
        week13.setText(getResources().getString(R.string.work13));

        week14 = (RadioButton) findViewById(R.id.radioButtonWeek14);
        week14.setOnClickListener(radioListener);
        week14.setText(getResources().getString(R.string.work14));

        week15 = (RadioButton) findViewById(R.id.radioButtonWeek15);
        week15.setOnClickListener(radioListener);
        week15.setText(getResources().getString(R.string.work15));

        week16 = (RadioButton) findViewById(R.id.radioButtonWeek16);
        week16.setOnClickListener(radioListener);
        week16.setText(getResources().getString(R.string.work16));

        week17 = (RadioButton) findViewById(R.id.radioButtonWeek17);
        week17.setOnClickListener(radioListener);
        week17.setText(getResources().getString(R.string.work17));

        week18 = (RadioButton) findViewById(R.id.radioButtonWeek18);
        week18.setOnClickListener(radioListener);
        week18.setText(getResources().getString(R.string.work18));
    }




}