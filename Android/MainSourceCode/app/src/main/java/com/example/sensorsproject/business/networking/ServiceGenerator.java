package com.example.sensorsproject.business.networking;

import com.example.sensorsproject.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static ServiceGenerator sInstance;

    private static SensorsAPI sensorsAPI;

    private ServiceGenerator(){
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
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
