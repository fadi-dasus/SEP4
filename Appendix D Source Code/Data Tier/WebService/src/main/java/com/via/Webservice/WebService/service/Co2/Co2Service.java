package com.via.Webservice.WebService.service.Co2;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Co2.Co2Respository;
import com.via.Webservice.WebService.dao.Room.RoomRepository;
import com.via.Webservice.WebService.fcm.NotificationsService;
import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.model.Room;

@Service
public class Co2Service implements ICo2Service {

	@Autowired
	Co2Respository dao;
	
	@Autowired 
	RoomRepository roomRepository;
	
	@Autowired
	NotificationsService notificationsService;

	public Optional<Co2> getCo2ById(int id) {
		return dao.findById(id);
	}

	public List<Co2> getCo2ByRoom(int room_id) {
		Room room = new Room(room_id);
		return dao.findByRoom(room);
	}

	public List<Co2> getCo2ByRoomForToday(int room_id) {
		Room room = new Room(room_id);
		LocalDate date = LocalDate.now();

		return dao.findByRoomAndDate(room, date);
	}

	@Override
	public Co2 getTopByOrderByIdDescAndRoom(String name) {
		Room room = roomRepository.findByRoomName(name);
		
		if (room !=null) {
			notificationsService.setTopic(name);
			
			notificationsService.setRoom(room);
			
			notificationsService.setEnabled(true);
		
		return dao.findTopByRoomOrderByIdDesc(room);
		}
		else return null;
	}
}
