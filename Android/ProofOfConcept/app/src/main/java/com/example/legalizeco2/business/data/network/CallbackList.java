package com.example.legalizeco2.business.data.network;

import com.example.legalizeco2.business.model.MyRoom;
import com.example.legalizeco2.utils.AppExecutors;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackList {

    public static void getRoomList(Call<List<MyRoom>> call, MutableLiveData<List<MyRoom>> roomData){
        call.enqueue(new Callback<List<MyRoom>>() {
            @Override
            public void onResponse(Call<List<MyRoom>> call, Response<List<MyRoom>> response) {
                AppExecutors.getInstance().networkIO().execute(() -> {
                    if(response.isSuccessful()){
                        roomData.postValue(response.body());
                    }
                });
            }

            @Override
            public void onFailure(Call<List<MyRoom>> call, Throwable t) {

            }
        });
    }
}
