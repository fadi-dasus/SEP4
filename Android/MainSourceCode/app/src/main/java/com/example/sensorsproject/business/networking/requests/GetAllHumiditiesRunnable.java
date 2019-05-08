package com.example.sensorsproject.business.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.networking.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllHumiditiesRunnable implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<List<Humidity>> data;
    private String TAG;

    public GetAllHumiditiesRunnable(String tag, MutableLiveData<List<Humidity>> list){
        this.data = list;
        this.TAG = tag;
        sg = ServiceGenerator.getInstance();
    }

    @Override
    public void run() {
        try {
            Response<List<Humidity>> response = getApiCall().execute();

            if(response.code() == 200){
                List<Humidity> list = new ArrayList<>(response.body());
                data.postValue(list);
                Log.d(TAG, "onHumidityListFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onHumidityListFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<Humidity>> getApiCall(){
        return sg.getSensorsAPI().getAllHumidity();
    }
}
