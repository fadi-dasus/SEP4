package com.via.Webservice.WebService.dao.Room;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	public Room findByRoomName(String roomName);

}
