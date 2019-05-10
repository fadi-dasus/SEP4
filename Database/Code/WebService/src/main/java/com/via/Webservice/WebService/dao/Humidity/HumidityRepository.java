package com.via.Webservice.WebService.dao.Humidity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.model.Room;

public interface HumidityRepository extends CrudRepository<Humidity,Integer> {
	public List<Humidity> findByRoom(Room room);

}
