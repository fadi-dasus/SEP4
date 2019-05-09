package com.dataConnection.Sep4.SQL.Controllers;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.HumidityRepository;
import com.dataConnection.Sep4.SQL.dao.TemperatureRepository;
import com.dataConnection.Sep4.SQL.model.Device;
import com.dataConnection.Sep4.SQL.model.Humidity;
import com.dataConnection.Sep4.SQL.model.Room;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumidityController {

    @Autowired
    Co2Repository co2;

    @Autowired
    HumidityRepository humidity;

    @Autowired
    EUIMongoRepository er;

    @Autowired
    Room room;

    @Autowired
    Device device;

    private List<EUIMongo> EUI;

    public void loadHumidity() {
        humidity.deleteAll();
        EUI = er.findAll();

        for(int i =0; i< EUI.size(); i++)
        {
            humidity.save(new Humidity("unknown",EUI.get(i).getTimestamp(),EUI.get(i).getHumidity(),room = new Room("Unknown", device=new Device(EUI.get(i).getName(), EUI.get(i).getUie()))));
        }

        humidity.findAll().forEach(System.out::println);
        System.out.println("_______________________________");
    }


    @Scheduled(fixedRate = 5000)
    public void updateHumidity()
    {
        EUI = er.findAll();

        int value = EUI.size()-co2.findAll().size();

        for(int i =EUI.size()-value; i<EUI.size(); i++)
        {
            humidity.save(new Humidity("unknown",EUI.get(i).getTimestamp(),EUI.get(i).getHumidity(),room = new Room("Unknown", device=new Device(EUI.get(i).getName(), EUI.get(i).getUie()))));
        }
    }
}
