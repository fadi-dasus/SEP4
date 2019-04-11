package com.example.legalizeco2.business.data.network;

import com.example.legalizeco2.business.model.Room;

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

    private MutableLiveData<List<Room>> roomListData;

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

    public LiveData<List<Room>> getRoomList() {

        //refreshRoom();
        //Temporary variables for generating random rooms
        List<Room> tempRooms = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Random r = new Random();
            int rNum = r.nextInt(1000)+1;
            Room tempRoom = new Room(i, "RoomName: " + rNum);
            tempRooms.add(tempRoom);
        }
        roomListData.postValue(tempRooms);
        return roomListData;
    }

    public void refreshRoom() {
        Call<List<Room>> call =endpoints.getRoomList();

        CallbackList.getRoomList(call, roomListData);
    }

}
