package com.example.legalizeco2.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;

@Dao
public interface RoomDao {

    @Insert
    void insert (Room room);

    @Query("DELETE FROM room_table")
    void deleteAll();

    @Query("SELECT * FROM room_table ORDER BY room ASC")
    LiveData<List<Room>> getAllRooms();
}
