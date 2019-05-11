package com.via.Webservice.WebService.service.Admin;

import java.util.List;
import java.util.Optional;

import com.via.Webservice.WebService.model.Admin;

public interface IAdminService {

	public Optional<Admin> getAdminById(int id);

	public List<Admin> getAdminByUsername(String username);

}
