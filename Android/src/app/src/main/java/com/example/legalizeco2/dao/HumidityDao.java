package com.example.legalizeco2.dao;

import com.example.legalizeco2.model.Humidity;

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

    @Query("SELECT * FROM Humidity_table ORDER BY humidity ASC")
    LiveData<List<Humidity>> getAllHumidity();
}
