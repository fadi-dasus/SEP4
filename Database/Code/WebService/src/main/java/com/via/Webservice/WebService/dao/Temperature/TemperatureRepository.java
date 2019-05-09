package com.via.Webservice.WebService.dao.Temperature;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Temperature;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
	//List<Temperature> findByDate(LocalDate date);
	List<Temperature> findByRoom(Room roomid);
}
