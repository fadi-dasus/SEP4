package com.example.sensorsproject.business.data.networking;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.data.networking.requests.GetCo2sByRoomId;
import com.example.sensorsproject.business.data.networking.requests.GetHumiditiesByRoomId;
import com.example.sensorsproject.business.data.networking.requests.GetTemperaturesByRoomId;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.models.Warning;
import com.example.sensorsproject.business.data.networking.requests.GetAllCo2s;
import com.example.sensorsproject.business.data.networking.requests.GetAllHumidities;
import com.example.sensorsproject.business.data.networking.requests.GetAllRooms;
import com.example.sensorsproject.business.data.networking.requests.GetAllTemperatures;
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
    private MutableLiveData<List<CO2>> co2All;
    private MutableLiveData<List<Humidity>> humidityAll;
    private MutableLiveData<List<Temperature>> temperatureAll;

    //Measurements By Room Id
    private MutableLiveData<List<CO2>> co2ByRoomId;
    private MutableLiveData<List<Humidity>> humidityByRoomId;
    private MutableLiveData<List<Temperature>> temperatureByRoomId;

    //Runnables
    private GetAllRooms getAllRooms;
    private GetAllCo2s getAllCo2S;
    private GetAllHumidities getAllHumidities;
    private GetAllTemperatures getAllTemperatures;
    private GetAllWarnings getAllWarnings;
    private GetCo2sByRoomId getCo2SByRoomId;
    private GetHumiditiesByRoomId getHumiditiesByRoomId;
    private GetTemperaturesByRoomId getTemperaturesByRoomId;

    private NetworkHelper(){
        //Lists
        roomList = new MutableLiveData<>();
        warningList = new MutableLiveData<>();

        //Measurements
        co2All = new MutableLiveData<>();
        humidityAll = new MutableLiveData<>();
        temperatureAll = new MutableLiveData<>();

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

    public LiveData<List<CO2>> getAllCo2s() {
        return co2All;
    }

    public LiveData<List<Humidity>> getAllHumidities() { return humidityAll; }

    public LiveData<List<Temperature>> getAllTemperatures() {
        return temperatureAll;
    }

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

    public void searchAllCo2s(){
        //Networking Code
        if(getAllCo2S != null){
            getAllCo2S = null;
        }

        getAllCo2S = new GetAllCo2s(TAG, co2All);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllCo2S);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllHumidities(){
        //Networking Code
        if(getAllHumidities != null){
            getAllHumidities = null;
        }

        getAllHumidities = new GetAllHumidities(TAG, humidityAll);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllHumidities);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllTemperatures(){
        //Networking Code
        if(getAllTemperatures != null){
            getAllTemperatures = null;
        }

        getAllTemperatures = new GetAllTemperatures(TAG, temperatureAll);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllTemperatures);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllWarnings(){
        //Networking Code
        if(getAllWarnings != null){
            getAllWarnings = null;
        }

        getAllWarnings = new GetAllWarnings(TAG, warningList);
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
        Log.d(TAG, "searchTemperatureByRoomId: INIT TEMPERATURE SEARCH");
        if(getTemperaturesByRoomId != null){
            getTemperaturesByRoomId = null;
        }

        getTemperaturesByRoomId = new GetTemperaturesByRoomId(TAG, temperatureByRoomId, roomId);
        Log.d(TAG, "searchTemperatureByRoomId: CREATE TEMPERATURE SEARCH");
        AppExecutors.getInstance().networkIO().execute(getTemperaturesByRoomId);

        /*final Future handler = AppExecutors.getInstance().networkIO().submit(getTemperaturesByRoomId);
        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);*/
    }
}
