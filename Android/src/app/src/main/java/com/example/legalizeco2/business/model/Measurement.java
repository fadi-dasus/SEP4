package com.example.legalizeco2.business.model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "measurement_table")
public class Measurement {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @Embedded(prefix = "co2_")
    private CO2 co2;

    @Embedded(prefix = "hum_")
    private Humidity humidity;

    @Embedded(prefix = "tem_")
    private Temperature temperature;

    @Embedded(prefix = "roo_")
    private MyRoom myRoom;

    public Measurement(int id, CO2 co2, Humidity humidity, Temperature temperature, MyRoom myRoom) {
        this.id = id;
        this.co2 = co2;
        this.humidity = humidity;
        this.temperature = temperature;
        this.myRoom = myRoom;
    }

    public int getId() {
        return id;
    }

    public CO2 getCo2() {
        return co2;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public MyRoom getMyRoom() {
        return myRoom;
    }
}
