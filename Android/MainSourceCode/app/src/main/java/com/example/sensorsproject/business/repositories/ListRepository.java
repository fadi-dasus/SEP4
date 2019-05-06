package com.example.sensorsproject.business.repositories;

import androidx.lifecycle.LiveData;

import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.networking.NetworkHelper;

import java.util.List;

public class ListRepository {

    private static ListRepository sInstance;
    private NetworkHelper networkHelper;

    private ListRepository(){
        networkHelper = NetworkHelper.getInstance();
    }

    public LiveData<List<MyRoom>> getAllRooms(){
        return networkHelper.getAllRooms();
    }

    public void searchAllRooms(){
        networkHelper.searchAllRooms();
    }

    public static ListRepository getInstance(){
        if(sInstance == null){
            sInstance = new ListRepository();
        }
        return sInstance;
    }
}
