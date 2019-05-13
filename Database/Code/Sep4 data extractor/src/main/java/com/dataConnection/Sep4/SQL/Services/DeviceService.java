package com.dataConnection.Sep4.SQL.Services;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.DeviceRepository;
import com.dataConnection.Sep4.SQL.model.Device;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    Co2Repository co2;

    @Autowired
    DeviceRepository device;

    @Autowired
    EUIMongoRepository er;

    private List<EUIMongo> EUI;

    @Scheduled(initialDelay = 1200, fixedRate = 5000)
    public void updateDevie() {
        EUI = er.findAll();
        if (EUI != null && device.findAll() != null) {
            int value = EUI.size() - device.findAll().size();
            for (int i = EUI.size() - value; i < EUI.size(); i++) {

                Device d = device.findByUie(EUI.get(i).getUie());
                if (d != null) {
                    System.out.println("No values in db");
                } else {
                    device.save(new Device(EUI.get(i).getName(), EUI.get(i).getUie()));
                }
            }

        } else {
            System.out.println("No values in db");
        }
    }
}