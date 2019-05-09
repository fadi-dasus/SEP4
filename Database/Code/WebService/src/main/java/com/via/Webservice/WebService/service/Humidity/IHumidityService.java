package com.via.Webservice.WebService.service.Humidity;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Humidity;

public interface IHumidityService {
	public Optional<Humidity> findHumidityById(int id);
	public Iterable<Humidity> findAllHumidity();
	public List<Humidity>findByHumidityRoom(int room_id);

}
