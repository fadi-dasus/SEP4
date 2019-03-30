package com.onlinetutorialspoint.repository.db1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.db1.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}