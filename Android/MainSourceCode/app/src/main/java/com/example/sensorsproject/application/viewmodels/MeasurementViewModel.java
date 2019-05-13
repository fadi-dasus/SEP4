package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.repositories.MeasurementRepository;

import java.util.List;

public class MeasurementViewModel extends ViewModel {

    MeasurementRepository repository;

    public MeasurementViewModel(){
        repository = MeasurementRepository.getInstance();
    }

    /*
     * GET LIVE DATA
     */

    public LiveData<List<CO2>> getAllCo2sByRoomIdToday(){ return repository.getAllCo2sByRoomIdToday();}

    public LiveData<List<Humidity>> getAllHumiditiesByRoomIdToday() {return repository.getAllHumiditiesByRoomIdToday();}

    public LiveData<List<Temperature>> getAllTemperaturesByRoomIdToday() {return repository.getAllTemperaturesByRoomIdToday();}

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllCo2sByRoomIdToday(String roomId) {repository.searchAllCo2sByRoomIdToday(roomId);}

    public void searchAllHumiditiesByRoomIdToday(String roomId) {repository.searchAllHumiditiesByRoomIdToday(roomId);}

    public void searchAllTemperaturesByRoomIdToday(String roomId) {repository.searchAllTemperaturesByRoomIdToday(roomId);}
}
