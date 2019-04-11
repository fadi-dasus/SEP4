package com.example.legalizeco2;

import android.app.Application;

import com.example.legalizeco2.dao.CO2Dao;
import com.example.legalizeco2.dao.CustomerDao;
import com.example.legalizeco2.dao.HumidityDao;
import com.example.legalizeco2.dao.MeasurementDao;
import com.example.legalizeco2.dao.RoomDao;
import com.example.legalizeco2.dao.TemperatureDao;
import com.example.legalizeco2.dao.WarningDao;
import com.example.legalizeco2.model.Customer;
import com.example.legalizeco2.model.Warning;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

public class DatabaseHelper {

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


    DatabaseHelper(Application application){
        RoomDB database = RoomDB.getDatabase(application);
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
