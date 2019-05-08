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

public class GetAllCo2sRunnable implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<List<CO2>> data;
    private String TAG;

    public GetAllCo2sRunnable(String tag, MutableLiveData<List<CO2>> list){
        this.data = list;
        this.TAG = tag;
        sg = ServiceGenerator.getInstance();
    }

    @Override
    public void run() {
        try {
            Response<List<CO2>> response = getApiCall().execute();

            if(response.code() == 200){
                List<CO2> list = new ArrayList<>(response.body());
                data.postValue(list);
                Log.d(TAG, "onCO2ListFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onCO2ListFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<CO2>> getApiCall(){
        return sg.getSensorsAPI().getAllCo2();
    }
}
