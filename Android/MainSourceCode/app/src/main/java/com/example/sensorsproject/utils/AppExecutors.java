package com.example.sensorsproject.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    private static AppExecutors sInstance;

    public static AppExecutors getInstance(){
        if(sInstance == null){
            sInstance = new AppExecutors();
        }
        return sInstance;
    }

    private final ScheduledExecutorService networkIO = Executors.newScheduledThreadPool(5);

    public ScheduledExecutorService networkIO(){
        return networkIO;
    }
}