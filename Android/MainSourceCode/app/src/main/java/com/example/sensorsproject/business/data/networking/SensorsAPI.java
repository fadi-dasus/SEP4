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

    @GET("co2/roomtoday/{id}")
    Call<List<CO2>> getAllCo2ByRoomIdToday(@Path("id") String roomId);

    @GET("co2/room/{id}")
    Call<List<CO2>> getAllCo2ByRoomId(@Path("id") String roomId);

    /*
     * HUMIDITY
     */

    @GET("humidity/roomtoday/{id}")
    Call<List<Humidity>> getAllHumidityByRoomIdToday(@Path("id") String roomId);

    @GET("humidity/room/{id}")
    Call<List<Humidity>> getAllHumidityByRoomId(@Path("id") String roomId);

    /*
     * TEMPERATURE
     */

    @GET("temperature/roomtoday/{id}")
    Call<List<Temperature>> getAllTemperatureByRoomIdToday(@Path("id") String roomId);

    @GET("temperature/room/{id}")
    Call<List<Temperature>> getAllTemperatureByRoomId(@Path("id") String roomId);

    /*
     * WARNING
     */

    @GET("warning/room/{id}")
    Call<List<Warning>> getAllWarningsByRoomId(@Path("id") String roomId);

    /*
     * Firebase Cloud Messaging
     */

    @GET("fcm/subscribe/{topic}")
    Call<String> subscribeToFcm(@Path("topic") String roomName);
}
