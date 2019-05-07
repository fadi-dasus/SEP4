package com.example.sensorsproject.business.models;

import com.google.gson.annotations.Expose;

public class CO2 {

    private String id;

    @Expose
    private final double higheAcceptableValue = 5.5;

    @Expose
    private final double lowAcceptableValue = 0.1;

    private String value;

    private String timestamp;

    public CO2(String id, String value, String timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

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

    @Override
    public String toString() {
        return "CO2 ID: " + id + " Value: " + value;
    }
}