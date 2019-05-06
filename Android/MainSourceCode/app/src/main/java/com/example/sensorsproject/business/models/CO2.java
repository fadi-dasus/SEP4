package com.example.sensorsproject.business.models;

import java.sql.Date;

public class CO2 {

    private int id;

    private final double higheAcceptableValue = 5.5;

    private final double lowAcceptableValue = 0.1;

    private String businessKey;

    private String value;

    private Date timestamp;

    public CO2(int id, String businessKey, String value) {
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
        return "CO2 [id=" + id + ", higheAcceptableValue=" + higheAcceptableValue + ", lowAcceptableValue="
                + lowAcceptableValue + ", businessKey=" + businessKey + ", value=" + value + ", timestamp=" + timestamp
                + "]";
    }
}