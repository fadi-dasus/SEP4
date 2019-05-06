package com.example.sensorsproject.business.networking;

import com.example.sensorsproject.business.models.MyRoom;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SensorsAPI {

    /*
     * ROOM
     */

    //Get room list
    @GET("/roomAll")
    Call<List<MyRoom>> getAllRooms();
}
