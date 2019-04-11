package com.example.legalizeco2.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Measurement_table")
public class Measurement {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "measurement")
    private Integer id;

    private CO2 co2;

    private Humidity humidity;

    private Temperature temperature;

    private Room room;

}
