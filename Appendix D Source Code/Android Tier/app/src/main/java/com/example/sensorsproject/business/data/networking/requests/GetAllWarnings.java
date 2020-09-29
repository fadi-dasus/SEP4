package com.example.sensorsproject.business.data.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.Warning;
import com.example.sensorsproject.business.data.networking.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllWarnings implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<List<Warning>> data;
    private String TAG;
    private String roomId;

    public GetAllWarnings(String tag, MutableLiveData<List<Warning>> list, String roomId){
        this.data = list;
        this.TAG = tag;
        this.sg = ServiceGenerator.getInstance();
        this.roomId = roomId;
    }

    @Override
    public void run() {
        try {
            Response<List<Warning>> response = getApiCall().execute();

            if(response.code() == 200){
                List<Warning> list = new ArrayList<>(response.body());
                data.postValue(list);
                Log.d(TAG, "onWarningListFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onWarningListFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<Warning>> getApiCall(){
        return sg.getSensorsAPI().getAllWarningsByRoomId(roomId);
    }
}
