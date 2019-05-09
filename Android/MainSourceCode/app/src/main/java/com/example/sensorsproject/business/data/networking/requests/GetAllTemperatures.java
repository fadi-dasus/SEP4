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

public class GetAllTemperatures implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<List<Temperature>> data;
    private String TAG;

    public GetAllTemperatures(String tag, MutableLiveData<List<Temperature>> list){
        this.data = list;
        this.TAG = tag;
        this.sg = ServiceGenerator.getInstance();
    }

    @Override
    public void run() {
        try {
            Response<List<Temperature>> response = getApiCall().execute();

            if(response.code() == 200){
                List<Temperature> list = new ArrayList<>(response.body());
                data.postValue(list);
                Log.d(TAG, "onTemperatureListFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onTemperatureListFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<Temperature>> getApiCall(){
        return sg.getSensorsAPI().getAllTemperature();
    }
}
