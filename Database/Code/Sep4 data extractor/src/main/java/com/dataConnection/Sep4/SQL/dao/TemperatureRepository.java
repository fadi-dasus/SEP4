package com.dataConnection.Sep4.SQL.dao;

import com.dataConnection.Sep4.SQL.model.Temperature;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
    @Override
    List<Temperature> findAll();
}
