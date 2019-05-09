package com.example.sensorsproject.business.data.networking;

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

    @GET("room/all")
    Call<List<MyRoom>> getAllRooms();

    /*
     * CO2
     */

    @GET("co2/all")
    Call<List<CO2>> getAllCo2();

    @GET("co2/room/{id}")
    Call<List<CO2>> getAllCo2ByRoomId(@Path("id") String roomId);

    /*
     * HUMIDITY
     */

    @GET("humidity/all")
    Call<List<Humidity>> getAllHumidity();

    @GET("humidity/{id}")
    Call<List<Humidity>> getAllHumidityByRoomId(@Path("id") String roomId);

    /*
     * TEMPERATURE
     */

    @GET("temperature/all")
    Call<List<Temperature>> getAllTemperature();

    @GET("temperature/room/{id}")
    Call<List<Temperature>> getAllTemperatureByRoomId(@Path("id") String roomId);

    /*
     * WARNING
     */

    @GET("warning/all")
    Call<List<Warning>> getAllWarnings();
}
