package com.example.sensorsproject.business.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Warning {

    private String id;

    private String localDate;

    private String status;

    private String value;

    private MyRoom room;

    private String measurementType;

    public Warning(String id, String localDate, String status, String value, MyRoom room, String measurementType) {
        this.id = id;
        this.localDate = localDate;
        this.status = status;
        this.value = value;
        this.room = room;
        this.measurementType = measurementType;
    }

    public String getId() {
        return id;
    }

    public String getLocalDate() {
        return localDate;
    }

    public String getStatus() {
        return status;
    }

    public String getValue() {
        return value;
    }

    public MyRoom getRoom() {
        return room;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public GregorianCalendar getGregorianCalendar(){
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        try {
            date = sdf.parse(localDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return gregorianCalendar;
    }

    @Override
    public String toString() {
        return "Warning{" +
                "id='" + id + '\'' +
                ", localDate='" + localDate + '\'' +
                ", status='" + status + '\'' +
                ", value=" + value +
                ", room=" + room +
                ", measurementType='" + measurementType + '\'' +
                '}';
    }
}
