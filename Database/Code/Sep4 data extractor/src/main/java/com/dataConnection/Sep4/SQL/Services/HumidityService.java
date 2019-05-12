package com.dataConnection.Sep4.SQL.Services;

import com.dataConnection.Sep4.SQL.dao.HumidityRepository;

import com.dataConnection.Sep4.SQL.dao.RoomRepository;
import com.dataConnection.Sep4.SQL.model.Humidity;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HumidityService {


    @Autowired
    HumidityRepository humidity;

    @Autowired
    EUIMongoRepository er;

    @Autowired
    RoomRepository rr;

    private List<EUIMongo> EUI;

    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat mm = new SimpleDateFormat("yyyy-MM-dd");
    String strDate;
    Date dt;
    Date ld;

    @Scheduled(fixedRate = 5000)
    public void updateHumidity()
    {
        EUI = er.findAll();
        if(EUI!= null && humidity.findAll() != null) {

        int value = EUI.size()-humidity.findAll().size();

        try {
        for(int i =EUI.size()-value; i<EUI.size(); i++)
        {
            humidity.save(new Humidity(ld = mm.parse(strDate = mm.format(EUI.get(i).getDate())),"NORMAL",dt = sm.parse(strDate = sm.format(EUI.get(i).getDate())), EUI.get(i).getHumidity(),rr.findAll().get(EUI.get(i).getRoomId())));
        }
        }catch (Exception e){

        }
        }else{
            System.out.println("No values in db");
        }
    }
}
