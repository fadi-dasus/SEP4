package com.dataConnection.Sep4.SQL.Controllers;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.DeviceRepository;
import com.dataConnection.Sep4.SQL.model.Device;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceController {

    @Autowired
    Co2Repository co2;

    @Autowired
    DeviceRepository device;

    @Autowired
    EUIMongoRepository er;

    private List<EUIMongo> EUI;

    public void loadDevice() {
        device.deleteAll();
        EUI = er.findAll();
        for(int i =0; i< EUI.size(); i++)
        {
            device.save(new Device(EUI.get(i).getName(),EUI.get(i).getUie()));
        }

        device.findAll().forEach(System.out::println);
        System.out.println("_______________________________");
    }

    public void updateDevie()
    {
        EUI = er.findAll();

        int value = EUI.size()-co2.findAll().size();

        for(int i =EUI.size()-value; i<EUI.size(); i++)
        {
            device.save(new Device(EUI.get(i).getName(),EUI.get(i).getUie()));
        }
    }
}
