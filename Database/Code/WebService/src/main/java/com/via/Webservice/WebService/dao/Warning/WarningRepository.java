package com.via.Webservice.WebService.dao.Warning;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.model.Warning;

public interface WarningRepository extends CrudRepository<Warning, Integer> {

	Iterable<Warning> findByRoom(Room room);

}
