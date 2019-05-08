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

    public LiveData<List<CO2>> getAllCo2s(){ return repository.getAllCo2s();}

    public LiveData<List<Humidity>> getAllHumidities() {return repository.getAllHumidities();}

    public LiveData<List<Temperature>> getAllTemperatures() {return repository.getAllTemperatures();}

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllCo2s() {repository.searchAllCo2s();}

    public void searchAllHumidities() {repository.searchAllHumidities();}

    public void searchAllTemperatures() {repository.searchAllTemperatures();}
}
