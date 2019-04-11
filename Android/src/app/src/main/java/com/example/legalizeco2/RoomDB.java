package com.example.legalizeco2;

import android.content.Context;

import com.example.legalizeco2.dao.CO2Dao;
import com.example.legalizeco2.dao.CustomerDao;
import com.example.legalizeco2.dao.HumidityDao;
import com.example.legalizeco2.dao.MeasurementDao;
import com.example.legalizeco2.dao.RoomDao;
import com.example.legalizeco2.dao.TemperatureDao;
import com.example.legalizeco2.dao.WarningDao;
import com.example.legalizeco2.model.CO2;
import com.example.legalizeco2.model.Customer;
import com.example.legalizeco2.model.Humidity;
import com.example.legalizeco2.model.Measurement;
import com.example.legalizeco2.model.Temperature;
import com.example.legalizeco2.model.Warning;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CO2.class, Customer.class, Humidity.class, Measurement.class,
          Room.class, Temperature.class, Warning.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract CO2Dao co2Dao();
    public abstract CustomerDao customerDao();
    public abstract HumidityDao humidityDao();
    public abstract MeasurementDao measurementDao();
    public abstract RoomDao roomDao();
    public abstract TemperatureDao temperatureDao();
    public abstract WarningDao warningDao();

    private static volatile RoomDB INSTANCE;

    static RoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDB.class) {
                if (INSTANCE == null) {
                    // Create database here

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class,"word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
