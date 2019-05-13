package com.example.legalizeco2.business.data.database.dao;

import com.example.legalizeco2.business.model.Humidity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface HumidityDao {

    @Insert
    void insert(Humidity humidity);

    @Query("DELETE FROM Humidity_table")
    void deleteAll();

    @Query("SELECT * FROM Humidity_table")
    LiveData<List<Humidity>> getAllHumidity();
}
