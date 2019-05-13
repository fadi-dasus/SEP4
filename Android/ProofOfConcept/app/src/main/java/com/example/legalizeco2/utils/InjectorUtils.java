package com.example.legalizeco2.utils;

import android.content.Context;

import com.example.legalizeco2.application.viewmodel.ViewModelFactory;
import com.example.legalizeco2.business.data.database.DatabaseHelper;
import com.example.legalizeco2.business.data.database.RoomDB;
import com.example.legalizeco2.business.data.network.NetworkHelper;
import com.example.legalizeco2.business.data.repository.ListRepository;
import com.example.legalizeco2.business.model.MyRoom;

public class InjectorUtils {

    public static ListRepository provideListRepository(Context context){
        AppExecutors executors = AppExecutors.getInstance();
        DatabaseHelper databaseHelper = provideDatabaseHelper(context);
        NetworkHelper networkHelper = provideNetworkHelper();
        return ListRepository.getInstance(executors, networkHelper, databaseHelper);
    }

    public static NetworkHelper provideNetworkHelper(){
        return NetworkHelper.getInstance();
    }

    public static DatabaseHelper provideDatabaseHelper(Context context){
        return DatabaseHelper.getInstance(context);
    }

    public static ViewModelFactory provideViewModelFactory(Context context){
        ListRepository listRepository = provideListRepository(context);
        return new ViewModelFactory(listRepository);
    }
}
