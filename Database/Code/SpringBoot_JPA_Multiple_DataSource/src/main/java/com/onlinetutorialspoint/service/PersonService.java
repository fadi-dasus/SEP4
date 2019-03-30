package com.onlinetutorialspoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.model.db1.Person;
import com.onlinetutorialspoint.repository.db1.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepo;

	public List<Person> getAllPersons() {
		return (List<Person>) personRepo.findAll();
	}

	public Person savePerson(Person person) {
		return personRepo.save(person);
	}
}