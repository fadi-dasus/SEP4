package com.via.Webservice.WebService.dao.Customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
public List<Customer> findByUsername(String username);
}
