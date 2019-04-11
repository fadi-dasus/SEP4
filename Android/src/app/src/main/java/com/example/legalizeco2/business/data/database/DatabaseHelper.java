package com.example.legalizeco2.business.data.database;

import android.app.Application;
import android.content.Context;

import com.example.legalizeco2.business.data.database.dao.CO2Dao;
import com.example.legalizeco2.business.data.database.dao.CustomerDao;
import com.example.legalizeco2.business.data.database.dao.HumidityDao;
import com.example.legalizeco2.business.data.database.dao.MeasurementDao;
import com.example.legalizeco2.business.data.database.dao.RoomDao;
import com.example.legalizeco2.business.data.database.dao.TemperatureDao;
import com.example.legalizeco2.business.data.database.dao.WarningDao;
import com.example.legalizeco2.business.model.Customer;
import com.example.legalizeco2.business.model.Warning;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

public class DatabaseHelper {

    //Todo: Remove the m part of the attributes

    public CO2Dao mCo2Dao;
    public CustomerDao mCustomerDao;
    public HumidityDao mHumidityDao;
    public MeasurementDao mMeasurementDao;
    public RoomDao mRoomDao;
    public TemperatureDao mTemperatureDao;
    public WarningDao mWarningDao;


    private LiveData<List<Customer>> mAllCustomers;
    private LiveData<List<Room>> mAllRooms;
    private LiveData<List<Warning>> mAllWarnings;

    DatabaseHelper(Context context){
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
        // Room
        mRoomDao = database.roomDao();
        mAllRooms = mRoomDao.getAllRooms();
        // Temperature
        mTemperatureDao = database.temperatureDao();
        // Warning
        mWarningDao = database.warningDao();
        mAllWarnings = mWarningDao.getAllWarnings();
    }
}
