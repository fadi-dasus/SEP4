package com.dataConnection.Sep4.SQL.Services;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.HumidityRepository;

import com.dataConnection.Sep4.SQL.model.Humidity;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumidityService {

    @Autowired
    Co2Repository co2;

    @Autowired
    HumidityRepository humidity;

    @Autowired
    EUIMongoRepository er;

    private List<EUIMongo> EUI;

    public void loadHumidity() {
        humidity.deleteAll();
        EUI = er.findAll();

        for(int i =0; i< EUI.size(); i++)
        {
            humidity.save(new Humidity("NORMAL",EUI.get(i).getTimestamp(),EUI.get(i).getHumidity(),null));
        }

        humidity.findAll().forEach(System.out::println);
        System.out.println("_______________________________");
    }


    @Scheduled(fixedRate = 5000)
    public void updateHumidity()
    {
        EUI = er.findAll();
        if(EUI!= null && humidity.findAll() != null) {

        int value = EUI.size()-humidity.findAll().size();

        for(int i =EUI.size()-value; i<EUI.size(); i++)
        {
            humidity.save(new Humidity("NORMAL",EUI.get(i).getTimestamp(),EUI.get(i).getHumidity(),null));
        }
    }else{
            System.out.println("No values in db");
        }
    }
}
