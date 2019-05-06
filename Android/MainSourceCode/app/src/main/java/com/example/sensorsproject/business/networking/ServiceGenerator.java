package com.example.sensorsproject.business.networking;

import com.example.sensorsproject.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static SensorsAPI sensorsAPI =retrofit.create(SensorsAPI.class);

    public static SensorsAPI getSensorsAPI(){
        return sensorsAPI;
    }

}
