package com.example.sensorsproject.business.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.data.fcm.FCMHelper;
import com.example.sensorsproject.business.data.networking.NetworkHelper;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.utils.AppExecutors;
import com.example.sensorsproject.utils.Constants;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LiveDataRepository {

    private static LiveDataRepository sInstance;
    private FCMHelper fcmHelper;
    private NetworkHelper networkHelper;

    private MutableLiveData<CO2> liveCo2;
    private MutableLiveData<Humidity> liveHumidity;
    private MutableLiveData<Temperature> liveTemperature;
    private MutableLiveData<String> liveTimestamp;

    private LiveDataRepository(){
        fcmHelper = FCMHelper.getInstance();
        networkHelper = NetworkHelper.getInstance();

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

    public void subscribe(MyRoom room){
        fcmHelper.subscribe(room);
    }

    public void unsubscribe(String roomName){
        fcmHelper.unsubscribe(roomName);
    }

    public void subscribeToFcm(String roomName) {networkHelper.subscribeToFcm(roomName);}

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

    public LiveData<MyRoom> getCurrentRoom() {return fcmHelper.getCurrentRoom();}

    /*
     * SETTERS
     */

    public void getRecentLiveData(String roomId){

        //Retrieve data to LiveData after 3 seconds so Web API requests are successfully finished beforehand
        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                List<CO2> co2List = networkHelper.getCo2ByRoomId().getValue();
                List<Humidity> humList = networkHelper.getHumidityByRoomId().getValue();
                List<Temperature> tempList = networkHelper.getTemperatureByRoomId().getValue();

                //Check if co2ListByRoomId exists and has more than one item, if so update recent livedata with last item in the arraylist
                if(co2List != null){
                    if(co2List.size() > 0){
                        CO2 co2 = co2List.get(co2List.size() - 1);
                        liveCo2.postValue(co2);
                        GregorianCalendar gc = co2.getGregorianCalendar();
                        String month = gc.get(Calendar.MONTH) + "";
                        String day = gc.get(Calendar.DAY_OF_MONTH) + "";
                        String hour = gc.get(Calendar.HOUR) + "";
                        String minute = gc.get(Calendar.MINUTE) + "";
                        String second = gc.get(Calendar.SECOND) + "";

                        if(gc.get(Calendar.MONTH) < 10){
                            month = "0" + gc.get(Calendar.MONTH);
                        }
                        if(gc.get(Calendar.DAY_OF_MONTH) < 10){
                            day = "0" + gc.get(Calendar.DAY_OF_MONTH);
                        }
                        if(gc.get(Calendar.HOUR) < 10){
                            hour = gc.get(Calendar.HOUR) + "0";
                        }
                        if(gc.get(Calendar.MINUTE) < 10){
                            minute = gc.get(Calendar.MINUTE) + "0";
                        }
                        if(gc.get(Calendar.SECOND) < 10){
                            second = gc.get(Calendar.SECOND) + "0";
                        }

                        String nTimestamp = gc.get(Calendar.YEAR) + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
                        liveTimestamp.postValue(nTimestamp);
                    }
                }

                if(humList != null){
                    if(humList.size() > 0){
                        Humidity hum = humList.get(humList.size() - 1);
                        liveHumidity.postValue(hum);
                    }
                }

                if(tempList != null){
                    if(tempList.size() > 0){
                        Temperature temp = tempList.get(tempList.size() - 1);
                        liveTemperature.postValue(temp);
                    }
                }
            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);

    }

    private void setRecentLiveData(String roomId){
        networkHelper.searchCo2ByRoomId(roomId);
        networkHelper.searchHumidityByRoomId(roomId);
        networkHelper.searchTemperatureByRoomId(roomId);
        //Todo: Not sure if it is the right place to update recent live data
        getRecentLiveData(roomId);
    }

    public void setCurrentRoom(MyRoom room) {
        if (room != null) {
            setRecentLiveData(room.getId());
            fcmHelper.setCurrentRoom(room);
        }
    }
}
