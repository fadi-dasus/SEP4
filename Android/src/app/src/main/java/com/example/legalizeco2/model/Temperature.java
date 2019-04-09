package com.example.legalizeco2.model;

import java.sql.Date;

public class Temperature {

    private int id;

    private final double higheAcceptableValue = 5.5;

    private final double lowAcceptableValue = 0.1;

    private String businessKey;

    private String value;

    private Date timestamp;

    public Temperature() {

    }

    public Temperature(String businessKey, String value, Date timestamp) {

        this.businessKey = businessKey;
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getHigheAcceptableValue() {
        return higheAcceptableValue;
    }

    public double getLowAcceptableValue() {
        return lowAcceptableValue;
    }

    @Override
    public String toString() {
        return "Temperature [id=" + id + ", higheAcceptableValue=" + higheAcceptableValue + ", lowAcceptableValue="
                + lowAcceptableValue + ", businessKey=" + businessKey + ", value=" + value + ", timestamp=" + timestamp
                + "]";
    }
}
