package com.example.legalizeco2.business.data.network;

import android.util.Log;

import com.example.legalizeco2.business.model.MyRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    //Todo: Add a loop to fetch data every 10 minutes

    private String BASE_URL = "https://localhost:5001/v1/";

    private static NetworkHelper sInstance;
    private Retrofit retrofit;
    private APIEndpoints endpoints;

    private MutableLiveData<List<MyRoom>> roomListData;

    private NetworkHelper(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoints = retrofit.create(APIEndpoints.class);

        roomListData = new MutableLiveData<>();
    }

    public static NetworkHelper getInstance() {
        if(sInstance == null){
            synchronized (NetworkHelper.class){
                if(sInstance == null){
                    sInstance = new NetworkHelper();
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<MyRoom>> getRoomList() {
        //refreshRoom();
        //Temporary variables for generating random rooms
        List<MyRoom> tempMyRooms = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Random r = new Random();
            int rNum = r.nextInt(1000)+1;
            MyRoom tempMyRoom = new MyRoom(i, "RoomName: " + rNum);
            tempMyRooms.add(tempMyRoom);
        }
        roomListData.setValue(tempMyRooms);
        return roomListData;
    }

    public void refreshRoom() {
        Call<List<MyRoom>> call = endpoints.getRoomList();

        CallbackList.getRoomList(call, roomListData);
    }

}
