package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.repositories.MeasurementRepository;

public class MeasurementViewModel extends ViewModel {

    MeasurementRepository repository;

    public MeasurementViewModel(){
        repository = MeasurementRepository.getInstance();
    }

    /*
     * GET ONE CO2
     */

    public LiveData<CO2> getOneCo2(){
        return repository.getOneCo2();
    }

    public void searchOneCo2(String id){
        repository.searchOneCo2(id);
    }

    /*
     * GET ONE HUMIDITY
     */

    public LiveData<Humidity> getOneHumidity(){
        return repository.getOneHumidity();
    }

    public void searchOneHumidity(String id){
        repository.searchOneHumidity(id);
    }
}
