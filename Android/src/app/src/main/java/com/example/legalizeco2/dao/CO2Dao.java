package com.example.legalizeco2.dao;

import com.example.legalizeco2.model.CO2;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CO2Dao {

    @Insert
    void insert(CO2 co2);

    @Query("DELETE FROM CO2_table")
    void deleteAll();

    @Query("SELECT * FROM CO2_table ORDER BY co2 ASC")
    LiveData<List<CO2>> getAllCO2();
}