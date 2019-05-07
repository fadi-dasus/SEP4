package com.via.Webservice.WebService.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	//public Optional<Room> getRoomByName(String roomName);
}
