package com.via.Webservice.WebService.service.Co2;

import java.util.Optional;

import com.via.Webservice.WebService.model.Co2;

public interface ICo2Service {
	public Optional<Co2> findCo2ById(int id);
	public Iterable<Co2> findAllCo2();

}
