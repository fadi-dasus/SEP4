package com.via.Webservice.WebService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Customer;
import com.via.Webservice.WebService.service.Customer.CustomerService;

@RestController
@RequestMapping("/sep4/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable("id") Integer id) {
		Optional<Customer> customer = customerService.getCustomerById(id);
		return new ResponseEntity<Optional<Customer>>(customer, HttpStatus.OK);
	}

	@GetMapping("/username")
	public ResponseEntity<List<Customer>> getCustomerByUsername(@RequestParam("username") String username) {

		List<Customer> customer = customerService.getCustomerByUsername(username);

		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
	}

}
