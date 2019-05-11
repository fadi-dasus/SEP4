package com.example.sensorsproject.business.data.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.data.networking.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllCo2sByRoomIdToday implements  Runnable{

    private ServiceGenerator sg;                    //Returns Call for Retrofit Response
    private MutableLiveData<List<CO2>> data;        //LiveData reference from NetworkHelper
    private String TAG;                             //TAG for debugging
    private String roomId;                          //Room id reference for API

    public GetAllCo2sByRoomIdToday(String tag, MutableLiveData<List<CO2>> list, String roomId){
        this.data = list;
        this.TAG = tag;
        this.sg = ServiceGenerator.getInstance();
        this.roomId = roomId;
    }

    @Override
    public void run() {
        try {
            Response<List<CO2>> response = getApiCall().execute();

            if(response.code() == 200){
                List<CO2> list = new ArrayList<>(response.body());
                //Log.d(TAG, "");
                data.postValue(list);
                Log.d(TAG, "onCO2ListTodayFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onCO2ListTodayFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<CO2>> getApiCall(){
        return sg.getSensorsAPI().getAllCo2ByRoomIdToday(roomId);
    }
}
