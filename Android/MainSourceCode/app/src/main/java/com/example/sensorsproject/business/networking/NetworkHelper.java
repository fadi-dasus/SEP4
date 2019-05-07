package com.example.sensorsproject.business.networking;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.networking.requests.GetAllRoomsRunnable;
import com.example.sensorsproject.business.networking.requests.GetOneDataRunnable;
import com.example.sensorsproject.utils.AppExecutors;
import com.example.sensorsproject.utils.Constants;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NetworkHelper {

    private static final String TAG = "NetworkHelper";

    private static NetworkHelper sInstance;

    //ListRepository
    private MutableLiveData<List<MyRoom>> roomList;

    //MeasurementRepository
    private MutableLiveData<CO2> oneCo2;
    private MutableLiveData<Humidity> oneHumidity;
    private GetAllRoomsRunnable getAllRoomsRunnable;

    private GetOneDataRunnable<CO2> getOneCo2Runnable;
    private GetOneDataRunnable<Humidity> getOneHumidityRunnable;

    private NetworkHelper(){
        roomList = new MutableLiveData<>();

        oneCo2 = new MutableLiveData<>();
        oneHumidity = new MutableLiveData<>();
    }

    public static NetworkHelper getInstance(){
        if(sInstance == null){
            sInstance = new NetworkHelper();
        }
        return sInstance;
    }

    /*
     * GET ALL ROOMS
     */

    public LiveData<List<MyRoom>> getAllRooms(){
        return roomList;
    }

    public void searchAllRooms(){
        //Networking Code
        if(getAllRoomsRunnable != null){
            getAllRoomsRunnable = null;
        }

        getAllRoomsRunnable = new GetAllRoomsRunnable(TAG, roomList);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllRoomsRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    /*
     * GET ONE CO2
     */
    public LiveData<CO2> getOneCo2(){
        return oneCo2;
    }

    public void searchOneCo2(String id){
        if(getOneCo2Runnable != null){
            getOneCo2Runnable = null;
        }
        getOneCo2Runnable = new GetOneDataRunnable<>(TAG, oneCo2, id, "co2");
        final Future handler = AppExecutors.getInstance().networkIO().submit(getOneCo2Runnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    /*
     * GET ONE HUMIDITY
     */

    public LiveData<Humidity> getOneHumidity(){
        return oneHumidity;
    }

    public void searchOneHumidity(String id){
        if(getOneHumidityRunnable != null){
            getOneHumidityRunnable = null;
        }

        getOneHumidityRunnable = new GetOneDataRunnable<>(TAG, oneHumidity, id, "humidity");
        final Future handler = AppExecutors.getInstance().networkIO().submit(getOneHumidityRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }
}
