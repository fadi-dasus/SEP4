package com.example.sensorsproject.business.data.networking;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.data.networking.requests.GetCo2sByRoomId;
import com.example.sensorsproject.business.data.networking.requests.GetHumiditiesByRoomId;
import com.example.sensorsproject.business.data.networking.requests.GetTemperaturesByRoomId;
import com.example.sensorsproject.business.data.networking.requests.SubscribeToFcm;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.models.Warning;
import com.example.sensorsproject.business.data.networking.requests.GetAllCo2sByRoomIdToday;
import com.example.sensorsproject.business.data.networking.requests.GetAllHumiditiesByRoomIdToday;
import com.example.sensorsproject.business.data.networking.requests.GetAllRooms;
import com.example.sensorsproject.business.data.networking.requests.GetAllTemperaturesByRoomIdToday;
import com.example.sensorsproject.business.data.networking.requests.GetAllWarnings;
import com.example.sensorsproject.utils.AppExecutors;
import com.example.sensorsproject.utils.Constants;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NetworkHelper {

    private static final String TAG = "NetworkHelper";

    private static NetworkHelper sInstance;

    //Lists
    private MutableLiveData<List<MyRoom>> roomList;
    private MutableLiveData<List<Warning>> warningList;

    //All Measurements
    private MutableLiveData<List<CO2>> co2ByRoomIdToday;
    private MutableLiveData<List<Humidity>> humidityByRoomIdToday;
    private MutableLiveData<List<Temperature>> temperatureByRoomIdToday;

    //Measurements By Room Id
    private MutableLiveData<List<CO2>> co2ByRoomId;
    private MutableLiveData<List<Humidity>> humidityByRoomId;
    private MutableLiveData<List<Temperature>> temperatureByRoomId;

    //Runnables
    private GetAllRooms getAllRooms;
    private GetAllCo2sByRoomIdToday getAllCo2SByRoomIdToday;
    private GetAllHumiditiesByRoomIdToday getAllHumiditiesByRoomIdToday;
    private GetAllTemperaturesByRoomIdToday getAllTemperaturesByRoomIdToday;
    private GetAllWarnings getAllWarnings;
    private GetCo2sByRoomId getCo2SByRoomId;
    private GetHumiditiesByRoomId getHumiditiesByRoomId;
    private GetTemperaturesByRoomId getTemperaturesByRoomId;
    private SubscribeToFcm subscribeToFcm;

    private NetworkHelper(){
        //Lists
        roomList = new MutableLiveData<>();
        warningList = new MutableLiveData<>();

        //Measurements
        co2ByRoomIdToday = new MutableLiveData<>();
        humidityByRoomIdToday = new MutableLiveData<>();
        temperatureByRoomIdToday = new MutableLiveData<>();

        //Measurements by id
        co2ByRoomId = new MutableLiveData<>();
        humidityByRoomId = new MutableLiveData<>();
        temperatureByRoomId = new MutableLiveData<>();
    }

    public static NetworkHelper getInstance(){
        if(sInstance == null){
            sInstance = new NetworkHelper();
        }
        return sInstance;
    }

    /*
     * LIVE DATA RETURNS
     */

    public LiveData<List<MyRoom>> getAllRooms() {
        return roomList;
    }

    public LiveData<List<CO2>> getAllCo2sByRoomIdToday() {
        return co2ByRoomIdToday;
    }

    public void searchAllCo2sByRoomIdToday(String roomId){
        //Networking Code
        if(getAllCo2SByRoomIdToday != null){
            getAllCo2SByRoomIdToday = null;
        }

        getAllCo2SByRoomIdToday = new GetAllCo2sByRoomIdToday(TAG, co2ByRoomIdToday, roomId);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllCo2SByRoomIdToday);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public LiveData<List<Humidity>> getAllHumiditiesByRoomIdToday() { return humidityByRoomIdToday; }

    public LiveData<List<Temperature>> getAllTemperaturesByRoomIdToday() { return temperatureByRoomIdToday; }

    public LiveData<List<Warning>> getAllWarnings() {
        return warningList;
    }

    public LiveData<List<CO2>> getCo2ByRoomId() {return co2ByRoomId;}

    public LiveData<List<Humidity>> getHumidityByRoomId() {return humidityByRoomId;}

    public LiveData<List<Temperature>> getTemperatureByRoomId() {return temperatureByRoomId;}

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllRooms(){
        //Networking Code
        if(getAllRooms != null){
            getAllRooms = null;
        }

        getAllRooms = new GetAllRooms(TAG, roomList);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllRooms);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }



    public void searchAllHumiditiesByRoomIdToday(String roomId){
        //Networking Code
        if(getAllHumiditiesByRoomIdToday != null){
            getAllHumiditiesByRoomIdToday = null;
        }

        getAllHumiditiesByRoomIdToday = new GetAllHumiditiesByRoomIdToday(TAG, humidityByRoomIdToday, roomId);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllHumiditiesByRoomIdToday);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllTemperaturesByRoomIdToday(String roomId){
        //Networking Code
        if(getAllTemperaturesByRoomIdToday != null){
            getAllTemperaturesByRoomIdToday = null;
        }

        getAllTemperaturesByRoomIdToday = new GetAllTemperaturesByRoomIdToday(TAG, temperatureByRoomIdToday, roomId);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllTemperaturesByRoomIdToday);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllWarningsByRoomId(String roomId){
        //Networking Code
        if(getAllWarnings != null){
            getAllWarnings = null;
        }

        getAllWarnings = new GetAllWarnings(TAG, warningList, roomId);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllWarnings);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchCo2ByRoomId(String roomId){
        //Networking Code
        if(getCo2SByRoomId != null){
            getCo2SByRoomId = null;
        }

        getCo2SByRoomId = new GetCo2sByRoomId(TAG, co2ByRoomId, roomId);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getCo2SByRoomId);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchHumidityByRoomId(String roomId){
        //Networking Code
        if(getHumiditiesByRoomId != null){
            getHumiditiesByRoomId = null;
        }
        
        getHumiditiesByRoomId = new GetHumiditiesByRoomId(TAG, humidityByRoomId, roomId);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getHumiditiesByRoomId);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchTemperatureByRoomId(String roomId){
        //Networking Code
        if(getTemperaturesByRoomId != null){
            getTemperaturesByRoomId = null;
        }

        getTemperaturesByRoomId = new GetTemperaturesByRoomId(TAG, temperatureByRoomId, roomId);
        //AppExecutors.getInstance().networkIO().execute(getTemperaturesByRoomId);

        final Future handler = AppExecutors.getInstance().networkIO().submit(getTemperaturesByRoomId);
        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void subscribeToFcm(String roomName){
        if(subscribeToFcm != null){
            subscribeToFcm = null;
        }

        subscribeToFcm = new SubscribeToFcm(TAG, roomName);

        final Future handler = AppExecutors.getInstance().networkIO().submit(subscribeToFcm);
        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }
}
