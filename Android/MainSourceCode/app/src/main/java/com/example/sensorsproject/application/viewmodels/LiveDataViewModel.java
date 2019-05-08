package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.repositories.LiveDataRepository;

public class LiveDataViewModel extends ViewModel {

    private LiveDataRepository repository;

    public LiveDataViewModel(){
        repository = LiveDataRepository.getInstance();
    }

    /*
     * SUBSCRIBE & UNSUBSCRIBE
     */

    public void subscribe(String roomName){
        repository.subscribe(roomName);
    }

    public void unsubscribe(String roomName){
        repository.unsubscribe(roomName);
    }

    /*
     * GET LIVE DATA
     */

    public LiveData<CO2> getLiveCo2(){
        return repository.getLiveCo2();
    }

    public LiveData<Humidity> getLiveHumidity(){
        return repository.getLiveHumidity();
    }

    public LiveData<Temperature> getLiveTemperature(){
        return repository.getLiveTemperature();
    }

    public LiveData<String> getLiveTimestamp(){
        return repository.getLiveTimestamp();
    }
}
