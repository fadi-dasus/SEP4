package com.example.legalizeco2.business.data.repository;

import android.content.Context;

import com.example.legalizeco2.business.data.database.DatabaseHelper;
import com.example.legalizeco2.business.data.network.NetworkHelper;
import com.example.legalizeco2.business.model.Room;
import com.example.legalizeco2.utils.AppExecutors;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class ListRepository {

    private ListRepository sInstance;

    private AppExecutors appExecutors;
    private NetworkHelper networkHelper;
    private DatabaseHelper databaseHelper;

    private MutableLiveData<List<Room>> roomListData;

    /*
     * 1. NetworkHelper updates every 10 minutes and notifies roomListData
     * 2. When roomListData changes, insert new changes to Database
     * 3. When database changes, getRoomList returns recent data
     * 4. When view calls getRoomList and sets observer for it, view has recent data
     */

    private ListRepository(AppExecutors executors, NetworkHelper networkHelper, DatabaseHelper databaseHelper){
        this.appExecutors = executors;
        this.networkHelper = networkHelper;
        this.databaseHelper = databaseHelper;

        networkHelper.getRoomList().observeForever(new Observer<List<Room>>() {
            @Override
            public void onChanged(List<Room> rooms) {
                updateRoom(rooms);
            }
        });
    }

    public ListRepository getInstance(AppExecutors executors, NetworkHelper networkHelper, DatabaseHelper databaseHelper){
        if(sInstance == null){
            synchronized (ListRepository.class){
                if(sInstance == null){
                    sInstance = new ListRepository(executors, networkHelper, databaseHelper);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<Room>> getRoomList(){
        return databaseHelper.mRoomDao.getAllRooms();
    }

    public void updateRoom(List<Room> rooms){
        appExecutors.diskIO().execute(() -> {
            if(databaseHelper.mRoomDao.getAllRooms() == null){
                databaseHelper.mRoomDao.insertAllRooms(rooms);
            } else {
                databaseHelper.mRoomDao.updateAllRooms(rooms);
            }
        });
    }
}
