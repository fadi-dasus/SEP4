package com.via.Webservice.WebService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Warning;

@Transactional
@Repository
public class WarningDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	public List<Warning> getAllWarnings(){
		String query = "select m from Warning m order by m.value";
		return (List<Warning>) entityManager.createQuery(query).getResultList();
	}
	
//	public Warning getWarningCo2(Co2Test co2) {
//		String high="550";
//		if(co2.getHigheacceptablevalue().equals(high)) {
//			return ;
//		}
//		return null;
//	}

}
