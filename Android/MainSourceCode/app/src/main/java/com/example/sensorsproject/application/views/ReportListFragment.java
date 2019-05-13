package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportListFragment extends Fragment {

    @BindView(R.id.report_co2_high) TextView textCo2High;
    @BindView(R.id.report_co2_low) TextView textCo2Low;
    @BindView(R.id.report_hum_high) TextView textHumHigh;
    @BindView(R.id.report_hum_low) TextView textHumLow;
    @BindView(R.id.report_temp_high) TextView textTempHigh;
    @BindView(R.id.report_temp_low) TextView textTempLow;
    @BindView(R.id.report_room_name) TextView textSampleData;

    private View fragmentView;

    private MeasurementViewModel measurementViewModel;
    private LiveDataViewModel liveDataViewModel;

    public ReportListFragment() {
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
        fragmentView = inflater.inflate(R.layout.fragment_report_list, container, false);
        ButterKnife.bind(this, fragmentView);
        //


        subscribeWebServiceObservers();

        return fragmentView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void subscribeWebServiceObservers(){
        measurementViewModel.getAllCo2sByRoomIdToday().observe(this, co2List -> {
            if(co2List != null){
                String toString = "";
                if(co2List.size() > 0){
                    for(CO2 co2 : co2List){
                        toString += co2.toString() + "\n";
                    }
                }
                Toast.makeText(getActivity(), toString, Toast.LENGTH_SHORT).show();
            }
        });

        measurementViewModel.getAllHumiditiesByRoomIdToday().observe(this, humidityList -> {
            if(humidityList != null){
                String toString = "";
                if(humidityList.size() > 0){
                    for(Humidity humidity : humidityList){
                        toString += humidity.toString() + "\n";
                    }
                }
                Toast.makeText(getActivity(), toString, Toast.LENGTH_SHORT).show();
            }
        });

        measurementViewModel.getAllTemperaturesByRoomIdToday().observe(this, temperatureList -> {
            if(temperatureList != null){
                String toString = "";
                if(temperatureList.size() > 0){
                    for(Temperature temperature : temperatureList){
                        toString += temperature.toString() + "\n";
                    }
                }
                Toast.makeText(getActivity(), toString, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
