package com.example.sensorsproject.business.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.sensorsproject.business.data.fcm.FCMHelper;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;

public class LiveDataRepository {

    private static LiveDataRepository sInstance;
    private FCMHelper fcmHelper;

    private MutableLiveData<CO2> liveCo2;
    private MutableLiveData<Humidity> liveHumidity;
    private MutableLiveData<Temperature> liveTemperature;
    private MutableLiveData<String> liveTimestamp;

    private LiveDataRepository(){
        fcmHelper = FCMHelper.getInstance();

        liveCo2 = new MutableLiveData<>();
        liveHumidity = new MutableLiveData<>();
        liveTemperature = new MutableLiveData<>();
        liveTimestamp = new MutableLiveData<>();

        observeFCMHelper();
    }

    public static LiveDataRepository getInstance(){
        if(sInstance == null){
            sInstance = new LiveDataRepository();
        }
        return sInstance;
    }

    /*
     * Observe FCMHelper for Cloud updates
     */

    private void observeFCMHelper(){
        fcmHelper.getLiveCo2().observeForever(co2 -> {
            if(co2 != null){
                liveCo2.postValue(co2);
            }
        });

        fcmHelper.getLiveHumidity().observeForever(hum -> {
            if(hum != null){
                liveHumidity.postValue(hum);
            }
        });

        fcmHelper.getLiveTemperature().observeForever(temp -> {
            if(temp != null){
                liveTemperature.postValue(temp);
            }
        });

        fcmHelper.getLiveTimestamp().observeForever(timestamp -> {
            if(timestamp != null){
                liveTimestamp.postValue(timestamp);
            }
        });
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
        return liveCo2;
    }

    public LiveData<Humidity> getLiveHumidity(){
        return liveHumidity;
    }

    public LiveData<Temperature> getLiveTemperature(){
        return liveTemperature;
    }

    public LiveData<String> getLiveTimestamp(){
        return liveTimestamp;
    }

    public LiveData<String> getCurrentRoom() {return fcmHelper.getCurrentRoom();}

    /*
     * SETTERS
     */

    public void setCurrentRoom(String roomName) {fcmHelper.setCurrentRoom(roomName);}
}
