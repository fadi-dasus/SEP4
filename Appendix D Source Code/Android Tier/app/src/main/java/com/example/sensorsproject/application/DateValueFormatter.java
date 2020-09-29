package com.example.sensorsproject.application;

import android.util.Log;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateValueFormatter extends ValueFormatter {

    private SimpleDateFormat sdf;

    private String[] mValues;


    public DateValueFormatter(String[] mValues) {
        this.mValues = mValues;
        sdf = new SimpleDateFormat("yyyy-dd-MM'T'HH:mm:ss");
    }

    @Override
    public String getFormattedValue(float value) {
        try {
            if(mValues.length > (int) value){
                Date date = sdf.parse(mValues[(int) value]);
                GregorianCalendar gc = new GregorianCalendar();
                String myTime;
                gc.setTime(date);
                if(gc.get(GregorianCalendar.MINUTE) < 10){
                    myTime = gc.get(GregorianCalendar.HOUR_OF_DAY) + ":" + gc.get(GregorianCalendar.MINUTE) + "0";
                } else {
                    myTime = gc.get(GregorianCalendar.HOUR_OF_DAY) + ":" + gc.get(GregorianCalendar.MINUTE);
                }
                return myTime;
            }
            return "";

        } catch (ParseException e) {
            e.printStackTrace();
            return mValues[(int) value];
        }
    }
}
