package com.via.Webservice.WebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Admin;
import com.via.Webservice.WebService.service.AdminService;

@RestController
@RequestMapping("/sep4")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") Integer id) {
		Admin admin = adminService.getAdminById(id);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);

	}

	@PostMapping("/admin")
	public ResponseEntity<Void> addAdmin(@RequestBody Admin admin)  {
		boolean exist = adminService.adminExist(admin.getUsername());
		if (exist) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		adminService.addAdmin(admin);

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping("/admin/username")
	public ResponseEntity<Admin> getAdminByUsername(@RequestParam("username") String username)
			 {

		Admin admin = adminService.getAdminByUsername(username);

		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

}
