package com.javasampleapproach.fcm;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private Button btn_subscribe;
    private Button btn_unsubscribe;

    private final String TOPIC = "F306";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_subscribe = (Button) findViewById(R.id.btn_subscribe);
        btn_unsubscribe = (Button) findViewById(R.id.btn_unsubscribe);



        btn_subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);
            }
        });

        btn_unsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseMessaging.getInstance().unsubscribeFromTopic(TOPIC);
            }
        });
    }
}