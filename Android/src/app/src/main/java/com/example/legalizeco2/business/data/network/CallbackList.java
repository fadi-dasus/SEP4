package com.example.legalizeco2.business.data.network;

import com.example.legalizeco2.business.model.Room;
import com.example.legalizeco2.utils.AppExecutors;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackList {

    public static void getRoomList(Call<List<Room>> call, MutableLiveData<List<Room>> roomData){
        call.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                AppExecutors.getInstance().networkIO().execute(() -> {
                    if(response.isSuccessful()){
                        roomData.postValue(response.body());
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {

            }
        });
    }
}
