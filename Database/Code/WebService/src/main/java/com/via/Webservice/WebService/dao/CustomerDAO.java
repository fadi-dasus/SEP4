package com.via.Webservice.WebService.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.via.Webservice.WebService.model.Customer;

@Transactional
@Repository
public class CustomerDAO {
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;
	
	public void addCustomer(Customer customer) {

		entityManager.persist(customer);

	}
	
	public Customer getCustomerById(int id) {
		return entityManager.find(Customer.class, id);
	}
	public Customer getCustomerByName(String username) {
		return entityManager.find(Customer.class, username);
	}
	
	public boolean customerExist(String username) {

		String jpql = "from Customer as m WHERE m.username = ?0 ";
		int count = entityManager.createQuery(jpql).setParameter(0, username).getResultList().size();
		return count > 0;

	}


}
