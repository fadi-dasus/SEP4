package com.example.sensorsproject.business.data.fcm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

public class FCMHelper {

    private static FCMHelper sInstance;
    private FirebaseMessaging firebaseMessaging;
    private String currentRoom;

    private MutableLiveData<CO2> liveCo2;
    private MutableLiveData<Humidity> liveHumidity;
    private MutableLiveData<Temperature> liveTemperature;
    private MutableLiveData<String> liveTimestamp;

    private FCMHelper(){
        currentRoom = "";
        firebaseMessaging = FirebaseMessaging.getInstance();
        liveCo2 = new MutableLiveData<>();
        liveHumidity = new MutableLiveData<>();
        liveTemperature = new MutableLiveData<>();
        liveTimestamp = new MutableLiveData<>();
    }

    public static FCMHelper getInstance(){
        if(sInstance == null){
            sInstance = new FCMHelper();
        }
        return sInstance;
    }

    public void subscribe(String roomName){
        currentRoom = roomName;
        Log.i("TEST", "A BENT JAU SUBSCRIBINI: " + roomName);
        firebaseMessaging.subscribeToTopic(currentRoom);
    }

    public void unsubscribe(String roomName){
        firebaseMessaging.unsubscribeFromTopic(currentRoom);
    }

    public LiveData<CO2> getLiveCo2() {
        return liveCo2;
    }

    public LiveData<Humidity> getLiveHumidity() {
        return liveHumidity;
    }

    public LiveData<Temperature> getLiveTemperature() {
        return liveTemperature;
    }

    public LiveData<String> getLiveTimestamp(){
        return liveTimestamp;
    }

    public void updateLiveData(CO2 co2, Humidity humidity, Temperature temperature, String timestamp){
        liveCo2.postValue(co2);
        liveHumidity.postValue(humidity);
        liveTemperature.postValue(temperature);
        liveTimestamp.postValue(timestamp);
    }
}
