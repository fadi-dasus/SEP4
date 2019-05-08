package com.example.sensorsproject.business.data.networking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.models.Warning;
import com.example.sensorsproject.business.data.networking.requests.GetAllCo2sRunnable;
import com.example.sensorsproject.business.data.networking.requests.GetAllHumiditiesRunnable;
import com.example.sensorsproject.business.data.networking.requests.GetAllRoomsRunnable;
import com.example.sensorsproject.business.data.networking.requests.GetAllTemperaturesRunnable;
import com.example.sensorsproject.business.data.networking.requests.GetAllWarningsRunnable;
import com.example.sensorsproject.business.data.networking.requests.GetOneDataRunnable;
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
    //Todo: ReportList webview links

    //Measurements
    private MutableLiveData<List<CO2>> co2List;
    private MutableLiveData<List<Humidity>> humidityList;
    private MutableLiveData<List<Temperature>> temperatureList;



    //Runnables
    private GetAllRoomsRunnable getAllRoomsRunnable;
    private GetAllCo2sRunnable getAllCo2sRunnable;
    private GetAllHumiditiesRunnable getAllHumiditiesRunnable;
    private GetAllTemperaturesRunnable getAllTemperaturesRunnable;
    private GetAllWarningsRunnable getAllWarningsRunnable;

    private NetworkHelper(){
        //Lists
        roomList = new MutableLiveData<>();
        warningList = new MutableLiveData<>();

        //Measurements
        co2List = new MutableLiveData<>();
        humidityList = new MutableLiveData<>();
        temperatureList = new MutableLiveData<>();


        //Unecessary
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
     * LIVE DATA RETURNS
     */

    public LiveData<List<MyRoom>> getAllRooms() {
        return roomList;
    }

    public LiveData<List<CO2>> getAllCo2s() {
        return co2List;
    }

    public LiveData<List<Humidity>> getAllHumidities() {
        return humidityList;
    }

    public LiveData<List<Temperature>> getAllTemperatures() {
        return temperatureList;
    }

    public LiveData<List<Warning>> getAllWarnings() {
        return warningList;
    }

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllRooms(){
        //Networking Code
        if(getAllRoomsRunnable != null){
            getAllRoomsRunnable = null;
        }

        getAllRoomsRunnable = new GetAllRoomsRunnable(TAG, roomList);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllRoomsRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllCo2s(){
        //Networking Code
        if(getAllCo2sRunnable != null){
            getAllCo2sRunnable = null;
        }

        getAllCo2sRunnable = new GetAllCo2sRunnable(TAG, co2List);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllCo2sRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllHumidities(){
        //Networking Code
        if(getAllHumiditiesRunnable != null){
            getAllHumiditiesRunnable = null;
        }

        getAllHumiditiesRunnable = new GetAllHumiditiesRunnable(TAG, humidityList);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllHumiditiesRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllTemperatures(){
        //Networking Code
        if(getAllTemperaturesRunnable != null){
            getAllTemperaturesRunnable = null;
        }

        getAllTemperaturesRunnable= new GetAllTemperaturesRunnable(TAG, temperatureList);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllTemperaturesRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public void searchAllWarnings(){
        //Networking Code
        if(getAllWarningsRunnable!= null){
            getAllWarningsRunnable = null;
        }

        getAllWarningsRunnable = new GetAllWarningsRunnable(TAG, warningList);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllWarningsRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            handler.cancel(true);
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    /*
     * UNECESSARY CODE
     */

    private MutableLiveData<CO2> oneCo2;
    private MutableLiveData<Humidity> oneHumidity;

    private GetOneDataRunnable<CO2> getOneCo2Runnable;
    private GetOneDataRunnable<Humidity> getOneHumidityRunnable;

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
