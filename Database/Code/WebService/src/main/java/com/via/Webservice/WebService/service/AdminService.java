package com.via.Webservice.WebService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.AdminDAO;
import com.via.Webservice.WebService.model.Admin;

@Service
public class AdminService {
	@Autowired
	public AdminDAO adminDAO;
	
	public boolean addAdmin(Admin admin)  {
		
		if (adminDAO.adminExist(admin.getUsername()) ) {
			return false;
		} else {
			adminDAO.addAdmin(admin);
			return true;
		}

	}
	
	public Admin getAdminById(int id) {
		return adminDAO.getAdminById(id);
	}

	public Admin getAdminByUsername(String username)  {

		return adminDAO.getAdminByName(username);
	}
	public boolean adminExist(String username)  {
		
		return adminDAO.adminExist(username);
	}
	
}
