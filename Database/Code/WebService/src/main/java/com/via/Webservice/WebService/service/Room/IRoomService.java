package com.via.Webservice.WebService.service.Room;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Room;

public interface IRoomService {
	public Optional<Room> findRoomById(int id);

	public Iterable<Room> findAllRoom();

	public List<Room> findByRoomName(String name);

}
