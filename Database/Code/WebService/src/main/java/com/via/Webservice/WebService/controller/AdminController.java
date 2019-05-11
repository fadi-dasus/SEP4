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

import com.via.Webservice.WebService.model.Admin;
import com.via.Webservice.WebService.service.Admin.AdminService;

@RestController
@RequestMapping("/sep4/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable("id") Integer id) {
		Optional<Admin> admin = adminService.getAdminById(id);
		return new ResponseEntity<Optional<Admin>>(admin, HttpStatus.OK);

	}

	@GetMapping("/username")
	public ResponseEntity<List<Admin>> getAdminByUsername(@RequestParam("username") String username) {

		List<Admin> admin = adminService.getAdminByUsername(username);

		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}

}
