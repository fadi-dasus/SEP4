package com.via.Webservice.WebService.dao.Co2;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.model.Room;

public interface Co2Respository extends CrudRepository<Co2, Integer> {
	public List<Co2> findByRoom(Room room);

	public List<Co2> findByRoomAndDate(Room room, LocalDate date);

	public Co2 findTopByRoomOrderByIdDesc(Room room);


}
