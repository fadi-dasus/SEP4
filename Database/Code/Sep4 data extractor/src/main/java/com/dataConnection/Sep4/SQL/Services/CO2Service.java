package com.dataConnection.Sep4.SQL.Services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.RoomRepository;
import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.SQL.model.Room;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;

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
    SimpleDateFormat mm = new SimpleDateFormat("yyyy-MM-dd");
    String strDate;
    Timestamp timestamp;
    LocalDate ld;

    @Scheduled(initialDelay = 1200, fixedRate = 5000)
    public void updateCO2() {
        EUI = er.findAll();
        if(EUI!= null && co2.findAll() != null) {

            int value = EUI.size()-co2.findAll().size();

            try {
                for(int i =EUI.size()-value; i<EUI.size(); i++)
                {
                	
                	Timestamp t = new Timestamp(EUI.get(i).getDate().getTime());   
                    ld = mm.parse(strDate = mm.format(EUI.get(i).getDate())).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    String Co2_value  = EUI.get(i).getCo2();
                    
                	
                	
                	double co2IntValue = Double.parseDouble(Co2_value);
                    timestamp = t;
                    Room room = rr.findAll().get(EUI.get(i).getRoomId());
                    Co2 co2New  = new Co2(co2IntValue,ld,timestamp,room);
                    
                    co2.save(co2New);
                }
            }catch (Exception e){
e.printStackTrace();
            }
        }else{
            System.out.println("No values in db");
        }
    }
}
