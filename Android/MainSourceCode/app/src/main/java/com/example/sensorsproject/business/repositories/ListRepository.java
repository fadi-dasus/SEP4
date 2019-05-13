package com.example.sensorsproject.business.repositories;

import androidx.lifecycle.LiveData;

import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Warning;
import com.example.sensorsproject.business.data.networking.NetworkHelper;

import java.util.List;

public class ListRepository {

    private static ListRepository sInstance;
    private NetworkHelper networkHelper;

    private ListRepository(){
        networkHelper = NetworkHelper.getInstance();
    }

    public static ListRepository getInstance(){
        if(sInstance == null){
            sInstance = new ListRepository();
        }
        return sInstance;
    }

    /*
     * GET LIVE DATA
     */

    public LiveData<List<MyRoom>> getAllRooms(){return networkHelper.getAllRooms(); }

    public LiveData<List<Warning>> getAllWarnings() {return networkHelper.getAllWarnings();}

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllRooms(){networkHelper.searchAllRooms();}

    public void searchAllWarningsByRoomId(String roomId) {networkHelper.searchAllWarningsByRoomId(roomId);}


}
