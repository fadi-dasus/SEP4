package com.via.Webservice.WebService.service.Humidity;

import java.util.Optional;

import com.via.Webservice.WebService.model.Humidity;

public interface IHumidityService {
	public Optional<Humidity> findHumidityById(int id);
	public Iterable<Humidity> findAllHumidity();

}
