package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.repositories.LiveDataRepository;

public class LiveDataViewModel extends ViewModel {

    private LiveDataRepository repository;
    private MutableLiveData<String> currentSensor;

    public LiveDataViewModel(){
        repository = LiveDataRepository.getInstance();
        currentSensor = new MutableLiveData<>();
    }

    /*
     * SUBSCRIBE & UNSUBSCRIBE
     */

    public void subscribe(MyRoom room){
        repository.subscribe(room);
    }

    public void unsubscribe(String roomName){
        repository.unsubscribe(roomName);
    }

    public void subscribeToFcm(String roomName) {repository.subscribeToFcm(roomName);}

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

    public LiveData<String> getCurrentSensor(){
        return currentSensor;
    }

    public LiveData<MyRoom> getCurrentRoom() {return repository.getCurrentRoom();}

    public void getRecentLiveData(String roomId) {repository.getRecentLiveData(roomId);}

    /*
     * SETTERS
     */

    public void setCurrentSensor(String sensorName){
        currentSensor.postValue(sensorName);
    }

    public void setCurrentRoom(MyRoom room) {repository.setCurrentRoom(room);}
}
