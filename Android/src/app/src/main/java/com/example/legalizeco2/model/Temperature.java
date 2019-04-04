package com.example.legalizeco2.model;

public class Temperature
{
    private int TID;
    private double tempCelsius;

    public Temperature(int TID, double tempCelsius)
    {
        this.TID=TID;
        this.tempCelsius=tempCelsius;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public double getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(double tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public int getTID()
    {
        return TID;
    }
}
