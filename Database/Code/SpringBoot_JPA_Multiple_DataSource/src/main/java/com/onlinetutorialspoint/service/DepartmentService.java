package com.onlinetutorialspoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.model.db2.Department;
import com.onlinetutorialspoint.repository.db2.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository deptRepo;

	public List<Department> getAllDepartment() {
		return (List<Department>) deptRepo.findAll();
	}

	public Department saveDepartment(Department dept) {
		return deptRepo.save(dept);
	}
}
