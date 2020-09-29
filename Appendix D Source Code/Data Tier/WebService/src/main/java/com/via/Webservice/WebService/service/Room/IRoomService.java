package com.via.Webservice.WebService.service.Room;

import java.util.Optional;

import com.via.Webservice.WebService.model.Room;

public interface IRoomService {
	public Optional<Room> getRoomById(int id);

	public Iterable<Room> getAllRoom();

	public Room getRoomByRoomName(String name);

}
