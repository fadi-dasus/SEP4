package com.dataConnection.Sep4.SQL.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dataConnection.Sep4.SQL.model.Co2;

public interface Co2Repository extends CrudRepository<Co2, Integer> {
	@Override
	List<Co2> findAll();

}
