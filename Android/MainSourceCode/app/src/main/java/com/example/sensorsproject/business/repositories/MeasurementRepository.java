package com.example.sensorsproject.business.repositories;

import androidx.lifecycle.LiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.networking.NetworkHelper;

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
     * GET ONE CO2
     */

    public LiveData<CO2> getOneCo2(){
        return networkHelper.getOneCo2();
    }

    public void searchOneCo2(String id){
        networkHelper.searchOneCo2(id);
    }

    /*
     * GET ONE HUMIDITY
     */

    public LiveData<Humidity> getOneHumidity(){
        return networkHelper.getOneHumidity();
    }

    public void searchOneHumidity(String id){
        networkHelper.searchOneHumidity(id);
    }
}
