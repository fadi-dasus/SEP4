package com.example.sensorsproject.application.views;


import android.icu.util.Measure;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.application.viewmodels.MeasurementViewModel;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayDataFragment extends Fragment {

    @BindView(R.id.button_co2)
    Button buttonCo2;
    @BindView(R.id.button_hum)
    Button buttonHum;
    @BindView(R.id.button_temp)
    Button buttonTemp;

    private MeasurementViewModel measurementViewModel;
    private LiveDataViewModel liveDataViewModel;

    private String roomId;

    public TodayDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        measurementViewModel = ViewModelProviders.of(getActivity()).get(MeasurementViewModel.class);
        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_data, container, false);
        ButterKnife.bind(this, view);

        roomId = liveDataViewModel.getCurrentRoom().getValue().getId();

        subscribeCo2Data();
        subscribeHumData();
        subscribeTempData();
        setOnClickListeners();

        return view;
    }

    public void subscribeCo2Data(){
        measurementViewModel.getAllCo2sByRoomIdToday().observe(this, co2s -> {
            if(co2s != null & co2s.size() > 0){
                Toast.makeText(getActivity(), "CO2: " + co2s.get(0).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void subscribeHumData(){
        measurementViewModel.getAllHumiditiesByRoomIdToday().observe(this, humidities -> {
            if(humidities != null && humidities.size() > 0){
                Toast.makeText(getActivity(), "HUM: " + humidities.get(0).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void subscribeTempData(){
        measurementViewModel.getAllTemperaturesByRoomIdToday().observe(this, temperatures -> {
            if(temperatures != null && temperatures.size() > 0) {
                Toast.makeText(getActivity(), "TEMP: " + temperatures.get(0).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOnClickListeners(){

        buttonCo2.setOnClickListener(v -> {
            measurementViewModel.searchAllCo2sByRoomIdToday(roomId);
        });

        buttonHum.setOnClickListener(v -> {
            measurementViewModel.searchAllHumiditiesByRoomIdToday(roomId);
        });

        buttonTemp.setOnClickListener(v -> {
            measurementViewModel.searchAllTemperaturesByRoomIdToday(roomId);
        });
    }

}
