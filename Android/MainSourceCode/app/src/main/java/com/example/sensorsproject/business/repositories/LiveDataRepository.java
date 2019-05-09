package com.example.sensorsproject.business.repositories;

import androidx.lifecycle.LiveData;

import com.example.sensorsproject.business.data.fcm.FCMHelper;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;

public class LiveDataRepository {

    private static LiveDataRepository sInstance;
    private FCMHelper fcmHelper;

    private LiveDataRepository(){
        fcmHelper = FCMHelper.getInstance();
    }

    public static LiveDataRepository getInstance(){
        if(sInstance == null){
            sInstance = new LiveDataRepository();
        }
        return sInstance;
    }

    /*
     * SUBSCRIBE & UNSUBSCRIBE
     */

    public void subscribe(String roomName){
        fcmHelper.subscribe(roomName);
    }

    public void unsubscribe(String roomName){
        fcmHelper.unsubscribe(roomName);
    }

    /*
     * GET LIVE DATA
     */

    public LiveData<CO2> getLiveCo2(){
        return fcmHelper.getLiveCo2();
    }

    public LiveData<Humidity> getLiveHumidity(){
        return fcmHelper.getLiveHumidity();
    }

    public LiveData<Temperature> getLiveTemperature(){
        return fcmHelper.getLiveTemperature();
    }

    public LiveData<String> getLiveTimestamp(){
        return fcmHelper.getLiveTimestamp();
    }

    public LiveData<String> getCurrentRoom() {return fcmHelper.getCurrentRoom();}

    /*
     * SETTERS
     */

    public void setCurrentRoom(String roomName) {fcmHelper.setCurrentRoom(roomName);}
}
