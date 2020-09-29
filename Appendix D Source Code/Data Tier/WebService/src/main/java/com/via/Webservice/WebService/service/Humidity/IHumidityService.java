package com.via.Webservice.WebService.service.Humidity;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Humidity;

public interface IHumidityService {
	public Optional<Humidity> getHumidityById(int id);

	public List<Humidity> getHumidityByRoom(int room_id);

	public List<Humidity> getHumidityByRoomForToday(int room_id);
}
