package com.example.sensorsproject.business.data.fcm;

import android.util.Log;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class ReceiveDataService extends FirebaseMessagingService {

    private static final String TAG = "ReceiveDataService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("TEST", "BENT KAZKA GAVO NORS");
        if (remoteMessage.getNotification() != null) {
            Log.i(TAG, "Title: " + remoteMessage.getNotification().getTitle());
            Log.i(TAG, "Body: " + remoteMessage.getNotification().getBody());
        }

        if(remoteMessage.getData().size() > 0){
            Map<String, String> map = remoteMessage.getData();
            String co2_value = map.get("co2_value");
            String hum_value = map.get("hum_value");
            String temp_value = map.get("temp_value");
            String timestamp = map.get("timestamp");

            Log.i(TAG, "onMessageReceived: " + co2_value);
            Log.i(TAG, "onMessageReceived: " + hum_value);
            Log.i(TAG, "onMessageReceived: " + temp_value);
            Log.i(TAG, "onMessageReceived: " + timestamp);

            CO2 co2 = new CO2(co2_value, timestamp);
            Humidity humidity = new Humidity(hum_value, timestamp);
            Temperature temperature = new Temperature(temp_value, timestamp);
            FCMHelper.getInstance().updateLiveData(co2, humidity, temperature, timestamp);
        }
    }
}
