package com.via.Webservice.WebService.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Co2;

@Transactional
@Repository
public class Co2DAO {

	@Autowired
	public Co2Respository co2Respository;

	public Optional<Co2> getCo2ById(int id) {
		return co2Respository.findById(id);
	}

	@SuppressWarnings("unchecked")
	public List<Co2> getAllCo2() {
		return (List<Co2>) co2Respository.findAll();
	}

}
