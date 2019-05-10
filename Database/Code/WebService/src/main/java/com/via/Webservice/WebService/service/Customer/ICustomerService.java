package com.via.Webservice.WebService.service.Customer;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Customer;

public interface ICustomerService {
	public Optional<Customer> findCustomerById(int id);

	public List<Customer> findByUsername(String username);

}
