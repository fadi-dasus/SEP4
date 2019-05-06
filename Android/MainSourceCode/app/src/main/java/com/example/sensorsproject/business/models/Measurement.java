package com.example.sensorsproject.business.models;

import androidx.annotation.NonNull;

public class Measurement {

    @NonNull
    private int id;

    private CO2 co2;

    private Humidity humidity;

    private Temperature temperature;

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
