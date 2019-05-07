package com.via.Webservice.WebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.RoomDAO;
import com.via.Webservice.WebService.model.Room;

@Service
public class RoomService {
	@Autowired
	RoomDAO dao;
	
	public Optional<Room> getRoomById(int id) {
		return dao.getRoomById(id);
	}

	public List<Room> getAllRoom() {
		return dao.getAllRoom();
	}
	public Room getRoomByName(String name) {
		return null;
			//	dao.getRoomByName(name);
	}

}
