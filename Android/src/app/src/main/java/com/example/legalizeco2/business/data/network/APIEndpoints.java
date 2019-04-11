package com.example.legalizeco2.business.data.network;

import com.example.legalizeco2.business.model.Room;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIEndpoints {

    @GET("rooms")
    Call<List<Room>> getRoomList();
}
