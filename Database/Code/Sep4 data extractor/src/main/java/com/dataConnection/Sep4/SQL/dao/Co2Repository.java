package com.dataConnection.Sep4.SQL.dao;

import com.dataConnection.Sep4.SQL.model.Co2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Co2Repository extends CrudRepository<Co2, Integer> {
    @Override
    List<Co2> findAll();

}
