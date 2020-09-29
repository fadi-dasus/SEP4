package com.via.Webservice.WebService.service.Room;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Room.RoomRepository;
import com.via.Webservice.WebService.model.Room;

@Service
public class RoomService implements IRoomService {
	@Autowired
	RoomRepository dao;

	public Optional<Room> getRoomById(int id) {
		return dao.findById(id);
	}

	public Iterable<Room> getAllRoom() {
		return dao.findAll();
	}

	public Room getRoomByRoomName(String name) {
		return dao.findByRoomName(name);
	}

}
