package com.example.legalizeco2.business.data.database.dao;

import com.example.legalizeco2.business.model.MyRoom;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface RoomDao {

    @Insert
    void insert (MyRoom myRoom);

    @Query("DELETE FROM room_table")
    void deleteAll();

    @Query("SELECT * FROM room_table")
    LiveData<List<MyRoom>> getAllRooms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllRooms(List<MyRoom> myRoomList);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateAllRooms(List<MyRoom> myRoomList);
}
