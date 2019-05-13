package com.example.legalizeco2.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.legalizeco2.R;
import com.example.legalizeco2.application.viewmodel.ListViewModel;
import com.example.legalizeco2.application.viewmodel.ViewModelFactory;
import com.example.legalizeco2.business.model.MyRoom;
import com.example.legalizeco2.utils.InjectorUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Todo: Create ListViewModel
    //Todo: Create ViewModelFactory
    //Todo: Create InjectorUtils
    //Todo: Create Simple Activity

    private TextView textView;
    private Button buttonRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonRefresh = findViewById(R.id.button_refresh);

        ViewModelFactory factory = InjectorUtils.provideViewModelFactory(this);
        ListViewModel listViewModel = ViewModelProviders.of(this, factory).get(ListViewModel.class);

        listViewModel.getRoomList().observe(this, new Observer<List<MyRoom>>() {
            @Override
            public void onChanged(List<MyRoom> myRooms) {
                String data = "";
                if(myRooms != null){
                    for(int i = 0; i < myRooms.size(); i++)
                        data += myRooms.get(i).toString() + "\n";
                        textView.setText(data);
                }
            }
        });

        buttonRefresh.setOnClickListener((View v) -> {
            listViewModel.getRoomList();
        });
    }
}
