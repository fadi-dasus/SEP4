package com.example.sensorsproject.business.data.networking.requests;

import android.util.Log;

import com.example.sensorsproject.business.data.networking.ServiceGenerator;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class SubscribeToFcm implements  Runnable{

    private ServiceGenerator sg;
    private String TAG;
    private String roomName;

    public SubscribeToFcm(String tag, String roomName){
        this.TAG = tag;
        this.sg = ServiceGenerator.getInstance();
        this.roomName = roomName;
    }

    @Override
    public void run() {
        try {
            Response<String> response = getApiCall().execute();
            if(response.code() == 200){
                Log.d(TAG, "onFCMSubscribeSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onFCMSubscribeFailure: " + response.errorBody().string());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<String> getApiCall(){
        return sg.getSensorsAPI().subscribeToFcm(roomName);
    }
}
