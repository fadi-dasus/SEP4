package com.dataConnection.Sep4.SQL.dao;

import com.dataConnection.Sep4.SQL.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    @Override
    List<Room> findAll();

}
