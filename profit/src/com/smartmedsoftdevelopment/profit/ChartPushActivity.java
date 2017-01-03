package com.smartmedsoftdevelopment.profit;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import lecho.lib.hellocharts.formatter.AxisValueFormatter;
import lecho.lib.hellocharts.formatter.SimpleAxisValueFormatter;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.model.*;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.LineChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ÑÂÊ on 03.04.2016.
 */

// https://github.com/lecho/hellocharts-android


public class ChartPushActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chartlayout);

        DrawAChart();

    }

    void DrawAChart()
    {
        LinearLayout layout = (LinearLayout)findViewById(R.id.chartlay);

        LineChartView chart = new LineChartView(this);
        layout.addView(chart);

        chart.setInteractive(true);
        chart.setZoomEnabled(true);
        chart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);

        DataHelper mDbHelper = new DataHelper(this);
        mDbHelper.openDataBase();
        SQLiteDatabase sdb;
        sdb = mDbHelper.getReadableDatabase();


        Cursor cursor = sdb.rawQuery("SELECT total FROM pushuphistory",
                null);
      //  cursor.moveToFirst();
        startManagingCursor(cursor);


        ArrayList<String> numberof = new ArrayList<String>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            // The Cursor is now set to the right position
            numberof.add(cursor.getString(cursor.getColumnIndex("total")));
        }



        List<PointValue> valuesofex = new ArrayList<PointValue>();

/*
    valuesofex.add(new PointValue(0, Integer.parseInt(numberof.get(0))));
    valuesofex.add(new PointValue(1, Integer.parseInt(numberof.get(1))));

     */
        for (int i = 0; i < numberof.size(); i++) {
            valuesofex.add(new PointValue(i, Integer.parseInt(numberof.get(i))));

        }



      //  String totl = cursor.getString(cursor.getColumnIndex("total"));


/*
        valuesofex.add(new PointValue(1,2));
        valuesofex.add(new PointValue(2,1));
        valuesofex.add(new PointValue(2,2));
*/

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(valuesofex).setColor(getResources().getColor(R.color.blue)).setCubic(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);


         Axis axisX = new Axis().generateAxisFromRange(0, 20, 1);


        Axis axisY = new Axis().setHasLines(true);
            axisX.setName(getResources().getString(R.string.day));

            axisY.setName(getResources().getString(R.string.numberofex));
        SimpleAxisValueFormatter axvf = new SimpleAxisValueFormatter();
        axvf.setDecimalDigitsNumber(0);

        axisY.setFormatter(axvf);
        axisY.setTextColor(getResources().getColor(R.color.gold));
        axisX.setTextColor(getResources().getColor(R.color.gold));
      //  axisX.setHasTiltedLabels(false);

        axisX.setFormatter(axvf);
        axisX.setHasTiltedLabels(false);



        data.setAxisXBottom(axisX);
        data.setAxisYLeft(axisY);





        chart.setLineChartData(data);
        chart.setZoomEnabled(false);
    }
}