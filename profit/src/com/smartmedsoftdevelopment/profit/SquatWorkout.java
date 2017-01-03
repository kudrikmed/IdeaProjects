package com.smartmedsoftdevelopment.profit;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by ÑÂÊ on 12.07.2016.
 */
public class SquatWorkout extends Activity {
    int i=120;
    int setnumber = 0;
    CountDownTimer mCountDownTimer;
    ArcProgress arcsit;
    TextView setofworkout;
    TextView setofset1;
    TextView setofset2;
    TextView setofset3;
    TextView setofset4;
    TextView setofset5;
    TextView timetext, totaltext, timenumbertext, totalnumbertext, caltext, calnumbertext;
    ImageView muscules;

    String set1, set2, set3, set4, set5;
    Integer tot, cal, week, day;

    SharedPreferences pref;

    Context context = this;

    public int WORKOUT_NUMBER;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.situpworkout);
        setofset1 = (TextView) this.findViewById(R.id.set0);
        setofset1.setBackgroundResource(R.drawable.header_oval_color);
        setofset2 = (TextView) this.findViewById(R.id.set1);
        setofset3 = (TextView) this.findViewById(R.id.set2);
        setofset4 = (TextView) this.findViewById(R.id.set3);
        setofset5 = (TextView) this.findViewById(R.id.set4);

        muscules = (ImageView) this.findViewById(R.id.imageView);
        muscules.setImageDrawable(getResources().getDrawable(R.drawable.msquats));

        timetext = (TextView) this.findViewById(R.id.time);
        totaltext = (TextView) this.findViewById(R.id.total);
        timenumbertext = (TextView) this.findViewById(R.id.timenumber);
        totalnumbertext = (TextView) this.findViewById(R.id.totalnumber);
        caltext = (TextView) this.findViewById(R.id.cal);
        calnumbertext = (TextView) this.findViewById(R.id.calnumber);

        timetext.setText(getResources().getString(R.string.time));
        totaltext.setText(getResources().getString(R.string.total));
        caltext.setText(getResources().getString(R.string.calburn));

        Context context;
        context = SquatWorkout.this;
        pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        DataHelper mDbHelper = new DataHelper(context);



        try {
            mDbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }


        mDbHelper.openDataBase();
        SQLiteDatabase sdb;
        sdb = mDbHelper.getReadableDatabase();

        int workoutnumber = pref.getInt("SQUAT_WORKOUT_NUMBER",0);

        if(workoutnumber == 0)
        {
            SharedPreferences.Editor edit = pref.edit();
            edit.putInt("SQUAT_WORKOUT_NUMBER", 1);
            edit.commit();
        }

        Cursor cursor = sdb.query("squats",
                null,
                "_id = " + pref.getInt("SQUAT_WORKOUT_NUMBER", 0), null,
                null, null, null);

        cursor.moveToFirst();

        set1 = cursor.getString(cursor.getColumnIndex("set1"));
        set2 = cursor.getString(cursor.getColumnIndex("set2"));
        set3 = cursor.getString(cursor.getColumnIndex("set3"));
        set4 = cursor.getString(cursor.getColumnIndex("set4"));
        set5 = cursor.getString(cursor.getColumnIndex("set5"));

        week = cursor.getInt(cursor.getColumnIndex("week"));
        day = cursor.getInt(cursor.getColumnIndex("day"));

        //  set5 = getString(workoutnumber);

        tot = Integer.parseInt(set1) + Integer.parseInt(set2) +Integer.parseInt(set3) +Integer.parseInt(set4) +Integer.parseInt(set5);
        totalnumbertext.setText(String.valueOf(tot));

        int tim = tot*4 + 120*4;
        cal = tim * 34 / 300;
        tim = tim / 60;
        timenumbertext.setText(String.valueOf(tim) + " min");
        calnumbertext.setText(String.valueOf(cal)+ "k");



        setofset1.setText(set1);
        setofset2.setText(set2);
        setofset3.setText(set3);
        setofset4.setText(set4);
        setofset5.setText(set5);
        setofworkout = (TextView) this.findViewById(R.id.set);
        setofworkout.setText(set1);

        mDbHelper.close();

    }



    public void MyTimer(View v)

    {
        setofworkout = (TextView) this.findViewById(R.id.set);
        setofworkout.setVisibility(View.INVISIBLE);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        //   mp.start();


        if (setnumber < 5) {
            arcsit = (ArcProgress) findViewById(R.id.sittimer);
            arcsit.setVisibility(View.VISIBLE);
            i = 120;
            arcsit.setProgress(i);
            arcsit.setTextColor(getResources().getColor(R.color.white));
            arcsit.setBottomText("rest");


            mCountDownTimer = new CountDownTimer(3000, 1000) {


                @Override
                public void onTick(long millisUntilFinished) {

                    Log.v("Log_tag", "Tick of Progress" + i + millisUntilFinished);
                    --i;
                    arcsit.setProgress(i);


                }

                @Override
                public void onFinish() {
                    //Do what you want
                    setnumber = setnumber + 1;
                    arcsit.setVisibility(View.INVISIBLE);
                    setofworkout.setVisibility(View.VISIBLE);



                    if (setnumber == 1) {
                        setofworkout.setText(set2);
                        setofset1.setBackgroundResource(R.drawable.header_oval);
                        setofset2.setBackgroundResource(R.drawable.header_oval_color);

                    }
                    if (setnumber == 2) {
                        setofworkout.setText(set3);
                        setofset2.setBackgroundResource(R.drawable.header_oval);
                        setofset3.setBackgroundResource(R.drawable.header_oval_color);

                    }
                    if (setnumber == 3) {
                        setofworkout.setText(set4);
                        setofset3.setBackgroundResource(R.drawable.header_oval);
                        setofset4.setBackgroundResource(R.drawable.header_oval_color);

                    }
                    if (setnumber == 4) {
                        setofworkout.setText(set5);
                        setofset4.setBackgroundResource(R.drawable.header_oval);
                        setofset5.setBackgroundResource(R.drawable.header_oval_color);

                    }
                    if (setnumber == 5) {
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putInt("SQUAT_WORKOUT_NUMBER", pref.getInt("SQUAT_WORKOUT_NUMBER", 0) + 1);
                        edit.commit();

                        DataHelper mDbHelper = new DataHelper(context);
                        mDbHelper.openDataBase();
                        SQLiteDatabase sdb;
                        sdb = mDbHelper.getWritableDatabase();

                        ContentValues values = new ContentValues();
                        values.put("week", week);
                        values.put("day", day);
                        values.put("calories", cal);
                        values.put("total", tot);


                        sdb.insert("squathistory", null, values);
                        mDbHelper.close();

                        setofworkout.setText("finished!");
                    }

                }
            }.start();
        }
        else
        {
            Intent intentGoToMain = new Intent(SquatWorkout.this, DashboardActivity.class);
            startActivity(intentGoToMain);
        }
    }



}
