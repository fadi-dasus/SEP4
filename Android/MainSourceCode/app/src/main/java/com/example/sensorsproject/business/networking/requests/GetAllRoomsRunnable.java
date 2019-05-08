package com.example.sensorsproject.business.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.networking.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllRoomsRunnable implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<List<MyRoom>> roomList;
    private String TAG;

    public GetAllRoomsRunnable(String tag, MutableLiveData<List<MyRoom>> list){
        this.roomList = list;
        this.TAG = tag;
        sg = ServiceGenerator.getInstance();
    }

    @Override
    public void run() {
        try {
            Response<List<MyRoom>> response = getApiCall().execute();

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

    private Call<List<MyRoom>> getApiCall(){
        return sg.getSensorsAPI().getAllRooms();
    }
}
