package com.via.Webservice.WebService.service.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Admin.AdminRepository;
import com.via.Webservice.WebService.model.Admin;

@Service
public class AdminService implements IAdminService {
	@Autowired
	public AdminRepository dao;

	public Optional<Admin> getAdminById(int id) {
		return dao.findById(id);
	}

	public List<Admin> getAdminByUsername(String username) {

		return dao.findByUsername(username);
	}

}
