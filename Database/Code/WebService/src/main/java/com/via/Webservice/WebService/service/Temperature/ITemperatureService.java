package com.via.Webservice.WebService.service.Temperature;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Temperature;

public interface ITemperatureService {
	public Optional<Temperature> getTemperatureById(int id);

	public List<Temperature> getTemperatureByRoom(int room_id);

	public List<Temperature> getTemperatureByRoomForToday(int room_id);

}
