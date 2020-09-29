package com.example.sensorsproject.business.repositories;

import androidx.lifecycle.LiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.data.networking.NetworkHelper;

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

    public LiveData<List<CO2>> getAllCo2sByRoomIdToday(){ return networkHelper.getAllCo2sByRoomIdToday();}

    public LiveData<List<Humidity>> getAllHumiditiesByRoomIdToday() {return networkHelper.getAllHumiditiesByRoomIdToday();}

    public LiveData<List<Temperature>> getAllTemperaturesByRoomIdToday() {return networkHelper.getAllTemperaturesByRoomIdToday();}

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllCo2sByRoomIdToday(String roomId) {networkHelper.searchAllCo2sByRoomIdToday(roomId);}

    public void searchAllHumiditiesByRoomIdToday(String roomId) {networkHelper.searchAllHumiditiesByRoomIdToday(roomId);}

    public void searchAllTemperaturesByRoomIdToday(String roomId) {networkHelper.searchAllTemperaturesByRoomIdToday(roomId);}
}
