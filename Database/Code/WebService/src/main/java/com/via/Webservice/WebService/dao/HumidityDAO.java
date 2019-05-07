package com.via.Webservice.WebService.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Humidity;

@Transactional
@Repository
public class HumidityDAO {
	@Autowired
	public HumidityRepository humidityRepository;

	public Optional<Humidity> getHumidityById(int id) {
		return humidityRepository.findById(id);
	}

	public List<Humidity> getAllHumidity() {

		return (List<Humidity>) humidityRepository.findAll();
	}

}
