package com.example.sensorsproject.business.data.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.data.networking.ServiceGenerator;
import com.example.sensorsproject.business.models.CO2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetCo2sByRoomId implements  Runnable{

    private ServiceGenerator sg;                    //Returns Call for Retrofit Response
    private MutableLiveData<List<CO2>> data;        //LiveData reference from NetworkHelper
    private String TAG;                             //TAG for debugging
    private String roomId;                          //Identifies from which room to request data

    public GetCo2sByRoomId(String tag, MutableLiveData<List<CO2>> list, String roomId){
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
                data.postValue(list);
                Log.d(TAG, "onCO2ListByIdFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "onCO2ListByIdFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<List<CO2>> getApiCall(){
        return sg.getSensorsAPI().getAllCo2ByRoomId(roomId);
    }
}
