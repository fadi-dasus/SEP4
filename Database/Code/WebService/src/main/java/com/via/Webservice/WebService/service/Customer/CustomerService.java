package com.via.Webservice.WebService.service.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Customer.CustomerRepository;
import com.via.Webservice.WebService.model.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	public CustomerRepository dao;

	public Optional<Customer> getCustomerById(int id) {
		return dao.findById(id);
	}

	public List<Customer> getCustomerByUsername(String username) {

		return dao.findByUsername(username);
	}

}
