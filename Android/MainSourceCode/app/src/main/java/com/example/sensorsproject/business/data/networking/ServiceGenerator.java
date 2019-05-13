package com.example.sensorsproject.business.data.networking;

import com.example.sensorsproject.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static ServiceGenerator sInstance;

    private static SensorsAPI sensorsAPI;

    private ServiceGenerator(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = retrofitBuilder.build();
        sensorsAPI = retrofit.create(SensorsAPI.class);
    }

    public static ServiceGenerator getInstance(){
        if(sInstance == null){
            sInstance = new ServiceGenerator();
        }
        return sInstance;
    }

    public SensorsAPI getSensorsAPI(){
        return sensorsAPI;
    }

}
