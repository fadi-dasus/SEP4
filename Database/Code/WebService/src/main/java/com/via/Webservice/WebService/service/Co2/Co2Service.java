package com.via.Webservice.WebService.service.Co2;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Co2.Co2Respository;
import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.model.Room;

@Service
public class Co2Service implements ICo2Service {

	@Autowired
	Co2Respository dao;

	public Optional<Co2> findCo2ById(int id) {
		return dao.findById(id);
	}
	public List<Co2> findByCo2Room(int room_id){
		Room room = new Room(room_id);
		return dao.findByRoom(room);
	}

	public Iterable<Co2> findAllCo2() {
		//Room room = new Room(room_id);
		return dao.findAll();
	}
	
	public List<Co2> findByCo2RoomForToday(int room_id){
		Room room = new Room(room_id);
		LocalDate date=LocalDate.now();
		
		return dao.findByRoomAndDate(room,date);
}
}
