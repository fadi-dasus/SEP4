package com.via.Webservice.WebService.service.Co2;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Co2;

public interface ICo2Service {
	public Optional<Co2> findCo2ById(int id);
	//public Iterable<Co2> findAllCo2();
	public List<Co2> findByCo2Room(int room_id);

}
