package com.via.Webservice.WebService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.CustomerDAO;
import com.via.Webservice.WebService.model.Customer;

@Service
public class CustomerService {

	@Autowired
	public CustomerDAO customerDAO;
	
	public boolean addCustomer(Customer customer)  {
			
		if (customerDAO.customerExist(customer.getUsername()) ) {
			return false;
		} else {
			customerDAO.addCustomer(customer);
			return true;
		}
		}
	
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}

	public Customer getCustomerByUsername(String username)  {

		return customerDAO.getCustomerByName(username);
	}
	
	public boolean customerExist(String username)  {
	
		return customerDAO.customerExist(username);
	}

}
