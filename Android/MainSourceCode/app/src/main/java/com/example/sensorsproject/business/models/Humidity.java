package com.example.sensorsproject.business.models;

import java.sql.Date;

public class Humidity {

    private int id;

    private final double higheAcceptableValue = 5.5;

    private final double lowAcceptableValue = 0.1;

    private String businessKey;

    private String value;

    private Date timestamp;

    public Humidity(int id, String businessKey, String value) {
        this.id = id;
        this.businessKey = businessKey;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public double getHigheAcceptableValue() {
        return higheAcceptableValue;
    }

    public double getLowAcceptableValue() {
        return lowAcceptableValue;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public String getValue() {
        return value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Humidity [id=" + id + ", higheAcceptableValue=" + higheAcceptableValue + ", lowAcceptableValue="
                + lowAcceptableValue + ", businessKey=" + businessKey + ", value=" + value + ", timestamp=" + timestamp
                + "]";
    }
}
