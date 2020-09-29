package com.example.sensorsproject.business.data.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.data.networking.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllHumiditiesByRoomIdToday implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<List<Humidity>> data;
    private String TAG;
    private String roomId;

    public GetAllHumiditiesByRoomIdToday(String tag, MutableLiveData<List<Humidity>> list, String roomId){
        this.data = list;
        this.TAG = tag;
        this.sg = ServiceGenerator.getInstance();
        this.roomId = roomId;
    }

    @Override
    public void run() {
        try {
            Response<List<Humidity>> response = getApiCall().execute();

            if(response.code() == 200){
                List<Humidity> list = new ArrayList<>(response.body());
                data.postValue(list);
                Log.d(TAG, "onHumidityTodayListFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onHumidityTodayListFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<Humidity>> getApiCall(){
        return sg.getSensorsAPI().getAllHumidityByRoomIdToday(roomId);
    }
}
