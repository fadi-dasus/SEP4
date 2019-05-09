package com.dataConnection.Sep4.SQL.Controllers;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.SQL.model.Device;
import com.dataConnection.Sep4.SQL.model.Room;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CO2Conttoller {

    @Autowired
    Co2Repository co2;

    @Autowired
    EUIMongoRepository er;

    private List<EUIMongo> EUI;

    private Room room;

    private Device device;

    public void loadCo2() {
        co2.deleteAll();
        EUI = er.findAll();

        for (int i = 0; i < EUI.size(); i++) {
            co2.save(new Co2("UNKNOWN", EUI.get(i).getTimestamp(), EUI.get(i).getCo2(), null));
        }

        co2.findAll().forEach(System.out::println);
        System.out.println("_______________________________");
    }
    

    @Scheduled(fixedRate = 5000)
    public void updateCO2() {
        EUI = er.findAll();
        if(EUI!= null && co2.findAll() != null) {

        int value = EUI.size() - co2.findAll().size();

        
        for (int i = EUI.size() - value; i < EUI.size(); i++) {
            co2.save(new Co2("UNKNOWN", EUI.get(i).getTimestamp(), EUI.get(i).getCo2(),null ));
        }
    }else
        {
            System.out.println("No values in db");
        }
    }
}
