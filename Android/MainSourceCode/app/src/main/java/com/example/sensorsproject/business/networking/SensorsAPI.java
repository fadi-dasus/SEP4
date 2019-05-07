package com.example.sensorsproject.business.networking;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.models.Warning;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SensorsAPI {

    /*
     * ROOM
     */

    @GET("/roomAll")
    Call<List<MyRoom>> getAllRooms();

    @GET("/room/{id}")
    Call<MyRoom> getOneRoom(@Path("id") String id);

    /*
     * CO2
     */

    @GET("co2All")
    Call<List<CO2>> getAllCo2();

    @GET("co2/{id}")
    Call<CO2> getOneCo2(@Path("id") String id);

    /*
     * HUMIDITY
     */

    @GET("humidityAll")
    Call<List<Humidity>> getAllHumidity();

    @GET("humidity/{id}")
    Call<Humidity> getOneHumidity(@Path("id") String id);

    /*
     * TEMPERATURE
     */

    @GET("temperatureAll")
    Call<List<Temperature>> getAllTemperature();

    @GET("temperature/{id}")
    Call<Temperature> getOneTemperature();

    /*
     * WARNING
     */

    @GET("warningAll")
    Call<List<Warning>> getAllWarnings();
}
