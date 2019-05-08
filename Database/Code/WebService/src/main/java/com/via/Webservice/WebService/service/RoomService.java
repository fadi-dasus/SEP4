package com.via.Webservice.WebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.RoomRepository;
import com.via.Webservice.WebService.model.Room;

@Service
public class RoomService {
	@Autowired
	RoomRepository dao;
	
	public Optional<Room> findRoomById(int id) {
		return dao.findById(id);
	}

	public Iterable<Room> findAllRoom() {
		return dao.findAll();
	}
	public List<Room> findByRoomName(String name) {
		return dao.findByRoomName(name);
	}

}
