package com.dataConnection.Sep4.SQL.Controllers;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.TemperatureRepository;
import com.dataConnection.Sep4.SQL.model.Device;
import com.dataConnection.Sep4.SQL.model.Room;
import com.dataConnection.Sep4.SQL.model.Temperature;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureController {

    @Autowired
    Co2Repository co2;

    @Autowired
    TemperatureRepository temperature;

    @Autowired
    EUIMongoRepository er;

    private List<EUIMongo> EUI;

    Room room;
    Device device;

    public void loadTemperature() {
        temperature.deleteAll();
        EUI = er.findAll();
        for(int i =0; i< EUI.size(); i++)
        {
            temperature.save(new Temperature("UNKNOWN",EUI.get(i).getTimestamp(),EUI.get(i).getTemperature(),null));
        }

        temperature.findAll().forEach(System.out::println);
        System.out.println("_______________________________");
    }


    @Scheduled(fixedRate = 5000)
    public void updateTemperature()
    {
        EUI = er.findAll();
        if(EUI!= null && co2.findAll() != null) {

        int value = EUI.size()-co2.findAll().size();


        for(int i =EUI.size()-value; i<EUI.size(); i++)
        {
            temperature.save(new Temperature("UNKNOWN",EUI.get(i).getTimestamp(),EUI.get(i).getTemperature(),null));
        }
    }else {
            System.out.println("No values in db");
        }
    }
}
