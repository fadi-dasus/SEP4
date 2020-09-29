package com.dataConnection.Sep4.SQL.dao;

import com.dataConnection.Sep4.SQL.model.Humidity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HumidityRepository extends CrudRepository<Humidity, Integer> {
    @Override
    List<Humidity> findAll();
}
