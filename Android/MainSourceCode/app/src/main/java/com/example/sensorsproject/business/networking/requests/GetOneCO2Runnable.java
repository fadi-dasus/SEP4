package com.example.sensorsproject.business.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.networking.ServiceGenerator;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class GetOneCO2Runnable implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<CO2> data;
    private String TAG;
    private String id;

    public GetOneCO2Runnable(String tag, MutableLiveData<CO2> data, String id){
        this.data = data;
        this.TAG = tag;
        this.id = id;
        sg = ServiceGenerator.getInstance();
    }

    @Override
    public void run() {
        try {
            Response<CO2> response = getData().execute();

            Log.d(TAG, "searchOneCo2: " + response.code());
            if(response.code() == 200){

                CO2 co2 = response.body();
                data.postValue(co2);
                Log.d(TAG, "onRoomListFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onRoomListFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<CO2> getData(){
        return sg.getSensorsAPI().getOneCo2(id);
    }
}
