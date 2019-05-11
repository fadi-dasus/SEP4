package com.dataConnection.Sep4.SQL.Services;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.RoomRepository;
import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class CO2Service {

    @Autowired
    Co2Repository co2;

    @Autowired
    EUIMongoRepository er;

    @Autowired
    RoomRepository rr;

    private List<EUIMongo> EUI;

    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strDate;
    Date dt;

    @Scheduled(fixedRate = 5000)
    public void updateCO2() {
        EUI = er.findAll();
        if(EUI!= null && co2.findAll() != null) {

        int value = EUI.size() - co2.findAll().size();

        try {
        for (int i = EUI.size() - value; i < EUI.size(); i++) {

            co2.save(new Co2("NORMAL",dt = sm.parse(strDate = sm.format(EUI.get(i).getDate())), EUI.get(i).getCo2(),rr.findAll().get(EUI.get(i).getRoomId())));
        }
        }catch (Exception e){

        }

        }else
        {
            System.out.println("No values in db");
        }
    }
}
