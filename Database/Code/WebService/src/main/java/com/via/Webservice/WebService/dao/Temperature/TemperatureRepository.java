package com.via.Webservice.WebService.dao.Temperature;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Temperature;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
	public List<Temperature> findByRoom(Room room);

	public List<Temperature> findByRoomAndDate(Room room, LocalDate date);
	
	public Temperature findTopByRoomOrderByIdDesc(Room room);

}
