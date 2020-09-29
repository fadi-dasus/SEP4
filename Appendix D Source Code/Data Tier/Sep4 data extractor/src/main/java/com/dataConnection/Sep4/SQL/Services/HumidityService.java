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

    Timestamp t1;
    Timestamp t;
    String Humidity_value;
    double HumidityIntValue;
    Room room;
    Humidity humidityNew;


    @Scheduled(initialDelay = 1200, fixedRate = 5000)
    public void updateHumidity() {
        EUI = er.findAll();
        if (EUI != null && humidity.findAll() != null) {

            if (humidity.findAll().size() != 0) {
                t1 = humidity.findAll().get(humidity.findAll().size() - 1).getTimestamp();
            } else {
                t1 = new Timestamp(0);
            }

            try {
                for (int i = 0; i < EUI.size(); i++) {
                    t = new Timestamp(EUI.get(i).getDate().getTime());
                    ld = mm.parse(strDate = mm.format(EUI.get(i).getDate())).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    Humidity_value = EUI.get(i).getHumidity();
                    HumidityIntValue = Double.parseDouble(Humidity_value);
                    timestamp = t;
                    room = rr.findAll().get(EUI.get(i).getRoomId());
                    humidityNew = new Humidity(HumidityIntValue, ld, timestamp, room);

                    if (t.after(t1)) {
                        humidity.save(humidityNew);
                    } else {
                        System.out.println("no update");
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}