package com.via.Webservice.WebService.dao;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Humidity;

public interface HumidityRepository extends CrudRepository<Humidity,Integer> {

}
