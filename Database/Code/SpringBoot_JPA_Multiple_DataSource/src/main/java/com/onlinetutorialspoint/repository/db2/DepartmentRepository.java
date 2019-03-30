package com.onlinetutorialspoint.repository.db2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.db1.Person;
import com.onlinetutorialspoint.model.db2.Department;
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{
}