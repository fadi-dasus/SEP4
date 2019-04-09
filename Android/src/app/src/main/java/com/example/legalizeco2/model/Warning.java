package com.example.legalizeco2.model;

import java.sql.Date;

public class Warning {

    private int ID;

    private String MeasurementType;

    private Date timeStamp;

    private boolean high;

    private boolean low;

    private double value;

    private String roomName;

    public Warning(String measurementType, Date timeStamp, boolean high, boolean low, double value, String roomName) {

        MeasurementType = measurementType;
        this.timeStamp = timeStamp;
        this.high = high;
        this.low = low;
        this.value = value;
        this.roomName = roomName;
    }

    public Warning() {

    }

    public int getID() {
        return ID;
    }

    public String getMeasurementType() {
        return MeasurementType;
    }

    public void setMeasurementType(String measurementType) {
        MeasurementType = measurementType;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isHigh() {
        return high;
    }

    public void setHigh(boolean high) {
        this.high = high;
    }

    public boolean isLow() {
        return low;
    }

    public void setLow(boolean low) {
        this.low = low;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Warning [ID=" + ID + ", MeasurementType=" + MeasurementType + ", timeStamp=" + timeStamp + ", high="
                + high + ", low=" + low + ", value=" + value + ", roomName=" + roomName + "]";
    }
}
