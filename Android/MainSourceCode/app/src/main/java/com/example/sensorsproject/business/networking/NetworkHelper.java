package com.example.sensorsproject.business.networking;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.networking.requests.GetAllRoomsRunnable;
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

    public LiveData<List<MyRoom>> getAllRooms(){
        return roomList;
    }

    public void searchAllRooms(){
        //Temporary Code

        ArrayList<MyRoom> list = new ArrayList<>();
        list.add(new MyRoom(0, "Room 0"));
        list.add(new MyRoom(1, "Room 1"));
        list.add(new MyRoom(2, "Room 2"));
        roomList.postValue(list);
        //Networking Code
       /* if(getAllRoomsRunnable != null){
            getAllRoomsRunnable = null;
        }

        getAllRoomsRunnable = new GetAllRoomsRunnable(TAG, roomList);
        final Future handler = AppExecutors.getInstance().networkIO().submit(getAllRoomsRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);*/
    }
}
