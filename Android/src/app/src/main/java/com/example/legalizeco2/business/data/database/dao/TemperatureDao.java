package com.example.legalizeco2.business.data.database.dao;

import com.example.legalizeco2.business.model.Temperature;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TemperatureDao {

    @Insert
    void insert(Temperature temperature);

    @Query("DELETE FROM temperature_table")
    void deleteAll();

    @Query("SELECT * FROM temperature_table")
    LiveData<List<Temperature>> getAllTemperatures();
}
