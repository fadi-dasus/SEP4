package com.example.legalizeco2.business.data.repository;

import android.util.Log;

import com.example.legalizeco2.business.data.database.DatabaseHelper;
import com.example.legalizeco2.business.data.network.NetworkHelper;
import com.example.legalizeco2.business.model.MyRoom;
import com.example.legalizeco2.utils.AppExecutors;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

public class ListRepository {

    private static ListRepository sInstance;

    private AppExecutors appExecutors;
    private NetworkHelper networkHelper;
    private DatabaseHelper databaseHelper;

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

        networkHelper.getRoomList().observeForever(new Observer<List<MyRoom>>() {
            @Override
            public void onChanged(List<MyRoom> myRooms) {
                updateRoom(myRooms);
            }
        });
    }

    public static ListRepository getInstance(AppExecutors executors, NetworkHelper networkHelper, DatabaseHelper databaseHelper){
        if(sInstance == null){
            synchronized (ListRepository.class){
                if(sInstance == null){
                    sInstance = new ListRepository(executors, networkHelper, databaseHelper);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<MyRoom>> getRoomList(){
        refreshRoomList();
        return databaseHelper.getRoomDao().getAllRooms();
    }

    public void refreshRoomList(){
        networkHelper.getRoomList();
    }

    public void updateRoom(List<MyRoom> myRooms){
        appExecutors.diskIO().execute(() -> {
            if(databaseHelper.getRoomDao().getAllRooms().getValue() == null){
                //Log.v("TEST", databaseHelper.getRoomDao().getAllRooms().getValue().get(0).toString());
                databaseHelper.getRoomDao().insertAllRooms(myRooms);
            } else {
                Log.v("TEST", "UPDATE KURWA");
                databaseHelper.getRoomDao().updateAllRooms(myRooms);
            }
        });
    }
}
