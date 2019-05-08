package com.example.sensorsproject.business.repositories;

import androidx.lifecycle.LiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.networking.NetworkHelper;

import java.util.List;

public class MeasurementRepository {

    private static MeasurementRepository sInstance;
    private NetworkHelper networkHelper;

    private MeasurementRepository(){
        networkHelper = NetworkHelper.getInstance();
    }

    public static MeasurementRepository getInstance(){
        if(sInstance == null){
            sInstance = new MeasurementRepository();
        }

        return sInstance;
    }

    /*
     * GET LIVE DATA
     */

    public LiveData<List<CO2>> getAllCo2s(){ return networkHelper.getAllCo2s();}

    public LiveData<List<Humidity>> getAllHumidities() {return networkHelper.getAllHumidities();}

    public LiveData<List<Temperature>> getAllTemperatures() {return networkHelper.getAllTemperatures();}

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllCo2s() {networkHelper.searchAllCo2s();}

    public void searchAllHumidities() {networkHelper.searchAllHumidities();}

    public void searchAllTemperatures() {networkHelper.searchAllTemperatures();}
}
