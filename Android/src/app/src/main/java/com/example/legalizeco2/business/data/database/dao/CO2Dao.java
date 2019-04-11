package com.example.legalizeco2.business.data.database.dao;

import com.example.legalizeco2.business.model.CO2;

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

    @Query("SELECT * FROM CO2_table")
    LiveData<List<CO2>> getAllCO2();
}