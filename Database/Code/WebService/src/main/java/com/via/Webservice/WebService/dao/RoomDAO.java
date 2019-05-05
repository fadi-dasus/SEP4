package com.via.Webservice.WebService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Room;

@Transactional
@Repository
public class RoomDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	public Room getRoomById(int id) {
		return entityManager.find(Room.class, id);
	}
	public List<Room> getAllRoom() {
		String query = "select m from Room m order by m.value";

		return (List<Room>) entityManager.createQuery(query).getResultList();
	}
	
	public Room getRoomByName(String roomName) {
		return entityManager.find(Room.class, roomName);
	}

}
