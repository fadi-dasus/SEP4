package com.example.legalizeco2.business.data.database.dao;

import com.example.legalizeco2.business.model.Measurement;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MeasurementDao {

    @Insert
    void insert(Measurement measurement);

    @Query("DELETE FROM Measurement_table")
    void deleteAll();

    @Query("SELECT * FROM measurement_table")
    LiveData<List<Measurement>> getAllMeasurements();

}
