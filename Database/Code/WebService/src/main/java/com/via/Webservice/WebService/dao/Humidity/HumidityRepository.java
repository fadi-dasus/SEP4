package com.via.Webservice.WebService.dao.Humidity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.model.Room;

public interface HumidityRepository extends CrudRepository<Humidity, Integer> {
	public List<Humidity> findByRoom(Room room);

	public List<Humidity> findByRoomAndDate(Room room, LocalDate date);
	
	public Humidity findTopByRoomOrderByIdDesc(Room room);

}
