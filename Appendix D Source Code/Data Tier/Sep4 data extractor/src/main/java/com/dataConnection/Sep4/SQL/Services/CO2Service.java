package com.dataConnection.Sep4.SQL.Services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dataConnection.Sep4.SQL.model.Device;
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

    Timestamp t1;
    Timestamp t;
    String Co2_value;
    double co2IntValue;
    Room room;
    Co2 co2New;


    @Scheduled(initialDelay = 1200, fixedRate = 5000)
    public void updateCO2() {
        EUI = er.findAll();
        if(EUI!= null && co2.findAll() != null) {

            if(co2.findAll().size() !=0) {
                t1 = co2.findAll().get(co2.findAll().size() - 1).getTimestamp();
            } else{
                t1 = new Timestamp(0);
            }

            try {
                for(int i =0; i<EUI.size(); i++)
                {
                    t = new Timestamp(EUI.get(i).getDate().getTime());
                    ld = mm.parse(strDate = mm.format(EUI.get(i).getDate())).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    Co2_value = EUI.get(i).getCo2();
                    co2IntValue = Double.parseDouble(Co2_value);
                    timestamp = t;
                    room = rr.findAll().get(EUI.get(i).getRoomId());
                    co2New = new Co2(co2IntValue, ld, timestamp, room);

                    if(t.after(t1)) {
                        co2.save(co2New);
                    }else
                    {
                        System.out.println("no update");
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}}