package com.via.Webservice.WebService.service.Humidity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Humidity.HumidityRepository;
import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.model.Room;

@Service
public class HumidityService implements IHumidityService {

	@Autowired
	HumidityRepository dao;

	public Optional<Humidity> getHumidityById(int id) {
		return dao.findById(id);
	}


	@Override
	public List<Humidity> getHumidityByRoom(int room_id) {
		Room room = new Room(room_id);
		return dao.findByRoom(room);
	}

	@Override
	public List<Humidity> getHumidityByRoomForToday(int room_id) {
		Room room = new Room(room_id);
		LocalDate date = LocalDate.now();
		return dao.findByRoomAndDate(room, date);
	}

}
