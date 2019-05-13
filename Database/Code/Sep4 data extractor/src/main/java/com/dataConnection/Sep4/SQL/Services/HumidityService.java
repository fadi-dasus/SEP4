package com.dataConnection.Sep4.SQL.Services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.HumidityRepository;
import com.dataConnection.Sep4.SQL.dao.RoomRepository;
import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.SQL.model.Humidity;
import com.dataConnection.Sep4.SQL.model.Room;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;

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
    Timestamp timestamp;
    LocalDate ld;

    @Scheduled(initialDelay = 1200, fixedRate = 5000)
    public void updateCO2() {
        EUI = er.findAll();
        if(EUI!= null && humidity.findAll() != null) {

            int value = EUI.size()-humidity.findAll().size();

            try {
                for(int i =EUI.size()-value; i<EUI.size(); i++)
                {
                	Timestamp t = new Timestamp(EUI.get(i).getDate().getTime()); 
                    ld = mm.parse(strDate = mm.format(EUI.get(i).getDate())).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    String Humidity_value  = EUI.get(i).getCo2();
                    timestamp = t;
                    Room room = rr.findAll().get(EUI.get(i).getRoomId());
                    Humidity humidityNew  = new Humidity(Humidity_value,ld,timestamp,room);
                    
                    humidity.save(humidityNew);

//                    co2.save(new Co2(ld,"NORMAL",dt = sm.parse(strDate = sm.format(EUI.get(i).getDate())), EUI.get(i).getCo2(),rr.findAll().get(EUI.get(i).getRoomId())));
                }
            }catch (Exception e){

            }
        }else{
            System.out.println("No values in db");
        }
    }
}
