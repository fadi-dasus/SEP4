package com.dataConnection.Sep4.SQL.dao;

import com.dataConnection.Sep4.SQL.model.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
    @Override
    List<Device> findAll();

    Device findByUie(String eui);

}
