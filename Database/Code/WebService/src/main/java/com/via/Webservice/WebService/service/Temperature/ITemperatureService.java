package com.via.Webservice.WebService.service.Temperature;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Temperature;

public interface ITemperatureService {
	public Optional<Temperature> findTemperatureById(int id);
	public Iterable<Temperature> findAllTemperature();
	public List<Temperature>findByTemperatureRoom(int room_id);

}
