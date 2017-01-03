package com.smartmedsoftdevelopment.profit;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ÑÂÊ on 24.02.2016.
 */


public class PushupStatistics extends Activity {

    SimpleCursorAdapter scAdapter;
    ListView lvData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pushuphistorylistview);

        // http://startandroid.ru/ru/uroki/vse-uroki-spiskom/111-urok-52-simplecursoradapter-primer-ispolzovanija

        DataHelper mDbHelper = new DataHelper(this);
        mDbHelper.openDataBase();
        SQLiteDatabase sdb;
        sdb = mDbHelper.getReadableDatabase();


        Cursor cursor = sdb.query("pushuphistory",
                null,
                null, null,
                null, null, null);
        startManagingCursor(cursor);

        String[] from = new String[] { "workout_at", "total" };
        int[] to = new int[] {  R.id.tvText , R.id.tv2Text};


        scAdapter = new SimpleCursorAdapter(this, R.layout.pushulistitem, cursor, from, to);
        lvData = (ListView) findViewById(R.id.lvData);
        lvData.setAdapter(scAdapter);

  /*    TextView date = (TextView) this.findViewById(R.id.date);
        date.setText("Date");

        TextView number = (TextView) this.findViewById(R.id.numberOfexercises);
        number.setText("Number of exercises");
        */

      //  Toast.makeText(this,cursor.getString(cursor.getColumnIndex("workout_at")), Toast.LENGTH_LONG).show();

    }
}