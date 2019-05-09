package com.example.sensorsproject.business.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Humidity {

    @Expose
    private final double higheAcceptableValue = 5.5;

    @Expose
    private final double lowAcceptableValue = 0.1;

    @SerializedName("humidity")
    private String value;
    private String timestamp;
    private MyRoom room;

    public Humidity(String value, String timestamp, MyRoom room) {
        this.value = value;
        this.timestamp = timestamp;
        this.room = room;
    }

    public double getHigheAcceptableValue() {
        return higheAcceptableValue;
    }

    public double getLowAcceptableValue() {
        return lowAcceptableValue;
    }


    public String getValue() {
        return value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public MyRoom getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Humidity: " + " Value: " + value + " Timestamp: " + timestamp + "Room: " + room.getRoomName();
    }
}
