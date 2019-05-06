package com.example.legalizeco2.business.data.database;

import android.content.Context;

import com.example.legalizeco2.business.data.database.dao.CO2Dao;
import com.example.legalizeco2.business.data.database.dao.CustomerDao;
import com.example.legalizeco2.business.data.database.dao.HumidityDao;
import com.example.legalizeco2.business.data.database.dao.MeasurementDao;
import com.example.legalizeco2.business.data.database.dao.RoomDao;
import com.example.legalizeco2.business.data.database.dao.TemperatureDao;
import com.example.legalizeco2.business.data.database.dao.WarningDao;
import com.example.legalizeco2.business.model.Customer;
import com.example.legalizeco2.business.model.MyRoom;
import com.example.legalizeco2.business.model.Warning;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

public class DatabaseHelper {

    //Todo: Remove the m part of the attributes

    private static DatabaseHelper sInstance;

    public static CO2Dao mCo2Dao;
    public static CustomerDao mCustomerDao;
    public static HumidityDao mHumidityDao;
    public static MeasurementDao mMeasurementDao;
    private RoomDao mRoomDao;
    public static TemperatureDao mTemperatureDao;
    public static WarningDao mWarningDao;


    private LiveData<List<Customer>> mAllCustomers;
    private LiveData<List<MyRoom>> mAllRooms;
    private LiveData<List<Warning>> mAllWarnings;

    private DatabaseHelper(Context context){
        RoomDB database = RoomDB.getDatabase(context);
        // CO2
        mCo2Dao = database.co2Dao();
        // Customer
        mCustomerDao = database.customerDao();
        mAllCustomers = mCustomerDao.getAllCustomers();
        // Humidity
        mHumidityDao = database.humidityDao();
        // Measurement
        mMeasurementDao = database.measurementDao();
        // MyRoom
        mRoomDao = database.roomDao();
        mAllRooms = mRoomDao.getAllRooms();
        // Temperature
        mTemperatureDao = database.temperatureDao();
        // Warning
        mWarningDao = database.warningDao();
        mAllWarnings = mWarningDao.getAllWarnings();
    }

    public static DatabaseHelper getInstance(Context context){
        if(sInstance == null){
            synchronized (DatabaseHelper.class){
                if(sInstance == null){
                    sInstance = new DatabaseHelper(context);
                }
            }
        }
        return sInstance;
    }

    public RoomDao getRoomDao() {
        return mRoomDao;
    }
}
