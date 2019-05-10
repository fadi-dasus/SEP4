package com.via.Webservice.WebService.dao.Admin;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
	public List<Admin> findByUsername(String username);
}
