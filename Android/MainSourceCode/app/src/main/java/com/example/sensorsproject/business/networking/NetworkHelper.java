package com.example.sensorsproject.business.networking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.utils.AppExecutors;
import com.example.sensorsproject.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class NetworkHelper {

    private static final String TAG = "NetworkHelper";

    private static NetworkHelper sInstance;

    private MutableLiveData<List<MyRoom>> roomList;

    private GetAllRoomsRunnable getAllRoomsRunnable;

    private NetworkHelper(){
        roomList = new MutableLiveData<>();
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

    public void getAllRooms(){
        if(getAllRoomsRunnable != null){
            getAllRoomsRunnable = null;
        }

        getAllRoomsRunnable = new GetAllRoomsRunnable();
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllRoomsRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    private class GetAllRoomsRunnable implements  Runnable{

        @Override
        public void run() {
            try {
                Response<List<MyRoom>> response = getAllRooms().execute();

                if(response.code() == 200){
                    List<MyRoom> list = new ArrayList<>(response.body());
                    roomList.postValue(list);
                    Log.d(TAG, "onRoomListFetchSuccess: Fetched successfully!");
                } else {
                    Log.d(TAG, "onRoomListFetchFailure: " + response.errorBody().string());
                    roomList.postValue(null);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private Call<List<MyRoom>> getAllRooms(){
            return ServiceGenerator.getSensorsAPI().getAllRooms();
        }
    }

}
