package com.via.Webservice.WebService.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Room;

@Transactional
@Repository
public class RoomDAO {

	@Autowired
	public RoomRepository entityManager;
	
	public Optional<Room> getRoomById(int id) {
		return entityManager.findById(id);
	}
	
	
	public List<Room> getAllRoom() {
		
		
		return (List<Room>) entityManager.findAll();
	
	
	
	
	 
	}
	



}
