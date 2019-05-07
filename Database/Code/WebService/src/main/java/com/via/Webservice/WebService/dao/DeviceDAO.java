package com.via.Webservice.WebService.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Device;

@Transactional
@Repository
public class DeviceDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	public Device getDeviceById(int id) {
		return entityManager.find(Device.class, id);
		
	}

}
