package com.dataConnection.Sep4.SQL.dao;

import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.SQL.model.Humidity;
import org.springframework.data.repository.CrudRepository;

public interface HumidityRepository extends CrudRepository<Humidity, Integer> {

}
