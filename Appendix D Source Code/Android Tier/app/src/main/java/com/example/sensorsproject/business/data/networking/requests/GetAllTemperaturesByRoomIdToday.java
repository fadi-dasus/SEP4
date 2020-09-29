package com.example.sensorsproject.business.data.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.data.networking.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllTemperaturesByRoomIdToday implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<List<Temperature>> data;
    private String TAG;
    private String roomId;

    public GetAllTemperaturesByRoomIdToday(String tag, MutableLiveData<List<Temperature>> list, String roomId){
        this.data = list;
        this.TAG = tag;
        this.sg = ServiceGenerator.getInstance();
        this.roomId = roomId;
    }

    @Override
    public void run() {
        try {
            Response<List<Temperature>> response = getApiCall().execute();

            if(response.code() == 200){
                List<Temperature> list = new ArrayList<>(response.body());
                data.postValue(list);
                Log.d(TAG, "onTemperatureListTodayFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onTemperatureListTodayFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<Temperature>> getApiCall(){
        return sg.getSensorsAPI().getAllTemperatureByRoomIdToday(roomId);
    }
}
