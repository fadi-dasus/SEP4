package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.MainActivity;
import com.example.sensorsproject.application.viewmodels.ListViewModel;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.nitri.gauge.Gauge;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomMainFragment extends Fragment {

    private ArrayAdapter<MyRoom> spinnerAdapter;
    private LiveDataViewModel liveDataViewModel;
    private ListViewModel listViewModel;

    @BindView(R.id.gauge) Gauge gauge;
    @BindView(R.id.spinner_main) Spinner mainSpinner;
    @BindView(R.id.room_textView_main) TextView mainRoomTextView;
    @BindView(R.id.co2_main_textView) TextView co2mainTextView;
    @BindView(R.id.temp_main_textView) TextView tempMainTextView;
    @BindView(R.id.hum_main_textView) TextView humMainTextView;
    @BindView(R.id.timestamp_main_textView) TextView timestampMainTextView;
    @BindView(R.id.co2_main_logo) ImageView co2MainLogoView;
    @BindView(R.id.temp_main_logo) ImageView tempMainLogoView;
    @BindView(R.id.hum_main_logo) ImageView humMaimLogoView;
    public RoomMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize view models
        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
        listViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);

        //Initialize spinner adapter
        spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Set current sensor according to XML Gauge view
        liveDataViewModel.setCurrentSensor("co2");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_main, container, false);
        ButterKnife.bind(this, view);

        //TEST
        Toast.makeText(getContext(), "Subscribed room: " + liveDataViewModel.getCurrentRoom().getValue(), Toast.LENGTH_SHORT).show();

        //Setting spinner adapter
        spinnerAdapter.clear();
        if(listViewModel.getAllRooms().getValue() != null){
            spinnerAdapter.clear();
            spinnerAdapter.addAll(listViewModel.getAllRooms().getValue());
        }
        mainSpinner.setAdapter(spinnerAdapter);

        //Initializes Spinner with a selected currentRoom from RoomChoice fragment
        List<MyRoom> allRooms = listViewModel.getAllRooms().getValue();
        MyRoom currentRoom = liveDataViewModel.getCurrentRoom().getValue();
        for(int i = 0; i < allRooms.size(); i++){
            if(allRooms.get(i).equals(currentRoom)){
                mainSpinner.setSelection(i);
                break;
            }
        }

        //Set up Gauge
        gauge.setNeedleStepFactor(10f);
        gauge.setDeltaTimeInterval(1);

        subscribeObservers();
        setOnClickListeners();
        return view;
    }

    private void setOnClickListeners(){
        tempMainLogoView.setOnClickListener(v -> {
            //Checks if the same sensor is not selected already
            if(!liveDataViewModel.getCurrentSensor().getValue().equals("temperature"))
                liveDataViewModel.setCurrentSensor("temperature");
        });


        co2MainLogoView.setOnClickListener(v -> {
            //Checks if the same sensor is not selected already
            if(!liveDataViewModel.getCurrentSensor().getValue().equals("co2"))
                liveDataViewModel.setCurrentSensor("co2");
        });

        humMaimLogoView.setOnClickListener(v -> {
            //Checks if the same sensor is not selected already
            if(!liveDataViewModel.getCurrentSensor().getValue().equals("humidity"))
                liveDataViewModel.setCurrentSensor("humidity");
        });

        mainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Todo: UPDATE THE MADNESS OF JUST SETTING A ROOM
                MyRoom currentRoom = (MyRoom) parent.getItemAtPosition(position);
                if(liveDataViewModel.getCurrentRoom().getValue() != null){
                    liveDataViewModel.unsubscribe(liveDataViewModel.getCurrentRoom().getValue().getRoomName());
                }
                liveDataViewModel.setCurrentRoom(currentRoom);
                liveDataViewModel.subscribe(currentRoom);
                liveDataViewModel.getRecentLiveData(currentRoom.getId());
                //Todo: Subscribes only to one room here, SHOULD BE TEMPORARY IN A WAY
                liveDataViewModel.subscribeToFcm(currentRoom.getRoomName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void subscribeObservers(){

        //Observe live data of sensors
        liveDataViewModel.getLiveCo2().observe(this, co2 -> {
            if(co2 != null){
                co2mainTextView.setText(co2.getValue());
                if(liveDataViewModel.getCurrentSensor().getValue() != null){
                    if(liveDataViewModel.getCurrentSensor().getValue().equals("co2")){
                        float f = Float.parseFloat(co2.getValue());
                        gauge.moveToValue(f);
                    }
                }
            }
        });

        liveDataViewModel.getLiveTemperature().observe(this, temp -> {
            if(temp != null){
                tempMainTextView.setText(temp.getValue());
                if(liveDataViewModel.getCurrentSensor().getValue() != null){
                    if(liveDataViewModel.getCurrentSensor().getValue().equals("temperature")){
                        float f = Float.parseFloat(temp.getValue());
                        gauge.moveToValue(f);
                    }
                }
            }
        });

        liveDataViewModel.getLiveHumidity().observe(this, hum -> {
            if (hum != null) {
                humMainTextView.setText(hum.getValue());
                if(liveDataViewModel.getCurrentSensor().getValue() != null){
                    if(liveDataViewModel.getCurrentSensor().getValue().equals("humidity")){
                        float f = Float.parseFloat(hum.getValue());
                        gauge.moveToValue(f);
                    }
                }
            }
        });

        liveDataViewModel.getLiveTimestamp().observe(this, timestamp -> {
            if(timestamp != null){
                timestampMainTextView.setText(timestamp);
            }
        });

        //Observe selected sensors
        liveDataViewModel.getCurrentSensor().observe(this, sensor -> {
            if(sensor != null){
                if(sensor.equals("co2")){
                    float co2Value = Float.parseFloat(co2mainTextView.getText().toString());
                    gauge.setLowerText("ppm");
                    gauge.setMaxValue(Constants.CO2_MAX_VALUE);
                    gauge.setMinValue(Constants.CO2_MIN_VALUE);
                    gauge.setUpperText("CO2");
                    gauge.setUpperTextSize(50);
                    gauge.setTotalNicks(120);
                    gauge.setValuePerNick(10);
                    gauge.moveToValue(co2Value);
                }
                else if(sensor.equals("humidity")){
                    float humValue = Float.parseFloat(humMainTextView.getText().toString());
                    gauge.setLowerText("%");
                    gauge.setMaxValue(Constants.HUMIDITY_MAX_VALUE);
                    gauge.setMinValue(Constants.HUMIDITY_MIN_VALUE);
                    gauge.setUpperText("Humidity");
                    gauge.setUpperTextSize(35);
                    gauge.setTotalNicks(120);
                    gauge.setValuePerNick(1);
                    gauge.moveToValue(humValue);
                }
                else if(sensor.equals("temperature")){
                    float tempValue = Float.parseFloat(tempMainTextView.getText().toString());
                    gauge.setLowerText("C");
                    gauge.setMaxValue(Constants.TEMPERATURE_MAX_VALUE);
                    gauge.setMinValue(Constants.TEMPERATURE_MIN_VALUE);
                    gauge.setUpperText("Temperature");
                    gauge.setUpperTextSize(35);
                    gauge.setTotalNicks(120);
                    gauge.setValuePerNick(1);
                    gauge.moveToValue(tempValue);
                }
            }
        });

    }

}
