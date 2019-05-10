package com.example.sensorsproject.business.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Warning {

    private String measurementType;

    private String timeStamp;

    private boolean high;

    private boolean low;

    private double value;

    private String roomName;

    public Warning(String measurementType, boolean high, boolean low, double value, String roomName, String timeStamp) {
        this.measurementType = measurementType;
        this.high = high;
        this.low = low;
        this.value = value;
        this.roomName = roomName;
        this.timeStamp = timeStamp;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public boolean isHigh() {
        return high;
    }

    public boolean isLow() {
        return low;
    }

    public double getValue() {
        return value;
    }

    public String getRoomName() {
        return roomName;
    }

    public GregorianCalendar getGregorianCalendar(){
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        try {
            date = sdf.parse(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return gregorianCalendar;
    }

    @Override
    public String toString() {
        return "Warning [measurementType=" + measurementType + ", timeStamp=" + timeStamp + ", high="
                + high + ", low=" + low + ", value=" + value + ", roomName=" + roomName + "]";
    }
}
