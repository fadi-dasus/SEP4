package com.example.legalizeco2.business.data.database.dao;

import com.example.legalizeco2.business.model.Warning;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WarningDao {

    @Insert
    void insert(Warning warning);

    @Query("DELETE FROM warning_table")
    void deleteAll();

    @Query("SELECT * FROM warning_table")
    LiveData<List<Warning>> getAllWarnings();
}
