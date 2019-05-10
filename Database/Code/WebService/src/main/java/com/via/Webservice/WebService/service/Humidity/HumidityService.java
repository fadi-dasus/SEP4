package com.via.Webservice.WebService.service.Humidity;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

	public Optional<Humidity> findHumidityById(int id) {
		return dao.findById(id);
	}

//	public Iterable<Humidity> findAll(int room_id) {
//		Room room=new Room(room_id);
//		return dao.findAll(room);
//	}


	@Override
	public List<Humidity> findByHumidityRoom(int room_id) {
		Room room=new Room(room_id);
		return dao.findByRoom(room);
	}

	
}
