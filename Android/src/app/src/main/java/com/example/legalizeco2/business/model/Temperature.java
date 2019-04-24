package com.example.legalizeco2.business.model;

import java.sql.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "temperature_table")
public class Temperature {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @Ignore
    private final double higheAcceptableValue = 5.5;

    @Ignore
    private final double lowAcceptableValue = 0.1;

    private String businessKey;

    private String value;

    @Ignore
    private Date timestamp;

    public Temperature(int id, String businessKey, String value) {
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
        return "Temperature [id=" + id + ", higheAcceptableValue=" + higheAcceptableValue + ", lowAcceptableValue="
                + lowAcceptableValue + ", businessKey=" + businessKey + ", value=" + value + ", timestamp=" + timestamp
                + "]";
    }
}
