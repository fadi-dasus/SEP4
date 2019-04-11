package com.example.legalizeco2.business.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "measurement_table")
public class Measurement {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private CO2 co2;

    private Humidity humidity;

    private Temperature temperature;

    private Room room;

}
