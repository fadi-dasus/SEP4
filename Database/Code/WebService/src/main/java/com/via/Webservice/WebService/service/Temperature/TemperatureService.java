package com.via.Webservice.WebService.service.Temperature;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Temperature.TemperatureRepository;
import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Temperature;
@Service
public class TemperatureService implements ITemperatureService{
	
	@Autowired
	TemperatureRepository dao;
	public EntityManager entityManager;
	
	public Optional<Temperature> findTemperatureById(int id) {
		return dao.findById(id);
	}

//	public Iterable<Temperature> findAllTemperature(int room_id) {
//		Room room=new Room(room_id);
//		return dao.findAll(room);
//	}

	@Override
	public List<Temperature> findByTemperatureRoom(int room_id) {
		Room room=new Room(room_id);
		return dao.findByRoom(room);
	}

}
