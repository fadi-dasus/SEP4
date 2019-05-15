package com.example.sensorsproject.business.data.fcm;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class ReceiveDataService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getData().size() > 0){
            Map<String, String> map = remoteMessage.getData();
            String co2_value = map.get("co2_value");
            String hum_value = map.get("hum_value");
            String temp_value = map.get("temp_value");
            String timestamp = map.get("timestamp");
            MyRoom room = FCMHelper.getInstance().getCurrentRoom().getValue();

            Log.d("TEST", "CO2: " + co2_value);
            Log.d("TEST", "HUMIDITY: " + hum_value);
            Log.d("TEST", "TEMP: " + temp_value);
            Log.d("TEST", "TIMESTAMP: " + timestamp);

            CO2 co2 = new CO2(co2_value, timestamp, room);
            Humidity humidity = new Humidity(hum_value, timestamp, room);
            Temperature temperature = new Temperature(temp_value, timestamp, room);
            FCMHelper.getInstance().updateLiveData(co2, humidity, temperature, timestamp);
        }
    }
}
