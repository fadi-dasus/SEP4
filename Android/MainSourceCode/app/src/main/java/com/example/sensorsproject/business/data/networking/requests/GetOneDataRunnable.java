package com.example.sensorsproject.business.data.networking.requests;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensorsproject.business.data.networking.ServiceGenerator;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class GetOneDataRunnable<T> implements  Runnable{

    private ServiceGenerator sg;
    private MutableLiveData<T> data;
    private String TAG;
    private String id;
    String type;

    public GetOneDataRunnable(String tag, MutableLiveData<T> data, String id, String type){
        this.data = data;
        this.TAG = tag;
        this.id = id;
        this.type = type;
        sg = ServiceGenerator.getInstance();
    }

    @Override
    public void run() {
        try {
            Response<T> response = getData().execute();

            Log.d(TAG, "searchOneCo2: " + response.code());
            if(response.code() == 200){

                T item = response.body();
                Log.d(TAG, "getData: HUMIDITY " + item.toString());
                data.postValue(item);
                Log.d(TAG, "on" + type + "ListFetchSuccess: Fetched successfully!");
            } else {
                Log.d(TAG, "on" + type + "ListFetchFailure: " + response.errorBody().string());
                data.postValue(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Call<T> getData(){

        if(type.equals("co2")){
            //noinspection unchecked
            return (Call<T>) sg.getSensorsAPI().getOneCo2(id);
        } else if(type.equals("humidity")){
            //noinspection unchecked
            return (Call<T>) sg.getSensorsAPI().getOneHumidity(id);
        }
        return null;
    }
}
