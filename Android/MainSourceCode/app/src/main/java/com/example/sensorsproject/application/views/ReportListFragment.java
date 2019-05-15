package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.application.viewmodels.MeasurementViewModel;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportListFragment extends Fragment {

    private static final String TAG = "ReportListFragment";

    @BindView(R.id.report_co2_high) TextView textCo2High;
    @BindView(R.id.report_co2_low) TextView textCo2Low;
    @BindView(R.id.report_hum_high) TextView textHumHigh;
    @BindView(R.id.report_hum_low) TextView textHumLow;
    @BindView(R.id.report_temp_high) TextView textTempHigh;
    @BindView(R.id.report_temp_low) TextView textTempLow;
    @BindView(R.id.report_sample_data) TextView textSampleData;
    @BindView(R.id.report_room_name) TextView textRoomName;

    private View fragmentView;

    private MeasurementViewModel measurementViewModel;
    private LiveDataViewModel liveDataViewModel;

    private String currentRoom;
    private String currentRoomId;

    public ReportListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        measurementViewModel = ViewModelProviders.of(getActivity()).get(MeasurementViewModel.class);
        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
        currentRoom = liveDataViewModel.getCurrentRoom().getValue().getRoomName();
        currentRoomId = liveDataViewModel.getCurrentRoom().getValue().getId();

        measurementViewModel.searchAllTemperaturesByRoomIdToday(currentRoomId);
        measurementViewModel.searchAllHumiditiesByRoomIdToday(currentRoomId);
        measurementViewModel.searchAllCo2sByRoomIdToday(currentRoomId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_report_list, container, false);
        ButterKnife.bind(this, fragmentView);
        //Set current room name
        textRoomName.setText(currentRoom);


        subscribeWebServiceObservers();

        return fragmentView;
    }

    private void updateCo2Values(List<CO2> co2List){
        if(co2List != null && co2List.size() > 0){
            float maxValue = -9999;
            float minValue = 9999;
            for(int i = 0; i < co2List.size(); i++){
                CO2 currentCo2 = co2List.get(i);
                float value = Float.parseFloat(currentCo2.getValue());
                if(value > maxValue) maxValue = value;
                else if(value < minValue) minValue = value;
            }

            textCo2High.setText("" + maxValue);
            textCo2Low.setText("" + minValue);
            textSampleData.setText("" + co2List.size());
        }
    }

    private void updateHumidityValues(List<Humidity> humidityList){
        if(humidityList != null && humidityList.size() > 0){
            float maxValue = -9999;
            float minValue = 9999;
            for(int i = 0; i < humidityList.size(); i++){
                Humidity currentHumidity = humidityList.get(i);
                float value = Float.parseFloat(currentHumidity.getValue());
                if(value > maxValue) maxValue = value;
                else if(value < minValue) minValue = value;
            }

            textHumHigh.setText("" + maxValue);
            textHumLow.setText("" + minValue);
        }
    }

    private void updateTemperatureValues(List<Temperature> temperatureList){
        if(temperatureList != null && temperatureList.size() > 0){
            float maxValue = -9999;
            float minValue = 9999;
            for(int i = 0; i < temperatureList.size(); i++){
                Temperature currentTemperature = temperatureList.get(i);
                float value = Float.parseFloat(currentTemperature.getValue());
                if(value > maxValue) maxValue = value;
                else if(value < minValue) minValue = value;
            }

            textTempHigh.setText("" + maxValue);
            textTempLow.setText("" + minValue);
        }
    }

    private void subscribeWebServiceObservers(){
        measurementViewModel.getAllCo2sByRoomIdToday().observe(this, co2List -> {
            if(co2List != null){
                updateCo2Values(co2List);
                Log.d(TAG, "subscribeWebServiceObservers: CO2LIST");
            }
        });

        measurementViewModel.getAllHumiditiesByRoomIdToday().observe(this, humidityList -> {
            if(humidityList != null){
                updateHumidityValues(humidityList);
                Log.d(TAG, "subscribeWebServiceObservers: HUMLIST");
            }
        });

        measurementViewModel.getAllTemperaturesByRoomIdToday().observe(this, temperatureList -> {
            if(temperatureList != null){
                updateTemperatureValues(temperatureList);
                Log.d(TAG, "subscribeWebServiceObservers: TEMPLIST");
            }
        });
    }
}
