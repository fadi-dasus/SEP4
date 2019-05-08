package com.via.Webservice.WebService.dao.Room;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	public List<Room> findByRoomName(String roomName);
}
