package com.example.sensorsproject.business.models;

import java.sql.Date;

public class Warning {

    private int id;

    private String measurementType;

    private Date timeStamp;

    private boolean high;

    private boolean low;

    private double value;

    private String roomName;

    public Warning(int id, String measurementType, boolean high, boolean low, double value, String roomName) {
        this.id = id;
        this.measurementType = measurementType;
        this.high = high;
        this.low = low;
        this.value = value;
        this.roomName = roomName;
    }

    public int getId() {
        return id;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public Date getTimeStamp() {
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

    @Override
    public String toString() {
        return "Warning [ID=" + id + ", measurementType=" + measurementType + ", timeStamp=" + timeStamp + ", high="
                + high + ", low=" + low + ", value=" + value + ", roomName=" + roomName + "]";
    }
}
