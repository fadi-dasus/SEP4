package com.example.sensorsproject.application.views;


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
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.application.viewmodels.MeasurementViewModel;
import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportListFragment extends Fragment {

    private View fragmentView;

    @BindView(R.id.text_live_co2) TextView textLiveCo2;
    @BindView(R.id.text_live_humidity) TextView textLiveHumidity;
    @BindView(R.id.text_live_temperature) TextView textLiveTemperature;
    @BindView(R.id.text_live_timestamp) TextView textLiveTimestamp;

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

        liveDataViewModel.subscribe("MyTopic");
        subscribeWebServiceObservers();
        subscribeLiveDataObservers();
        temporaryButtons();

        return fragmentView;
    }

    @Override
    public void onStop() {
        liveDataViewModel.unsubscribe("MyTopic");
        super.onStop();
    }

    private void subscribeLiveDataObservers(){
        liveDataViewModel.getLiveCo2().observe(this, co2 -> {
            if(co2 != null){
                textLiveCo2.setText(co2.getValue());
            }
        });

        liveDataViewModel.getLiveHumidity().observe(this, humidity -> {
            if(humidity != null){
                textLiveHumidity.setText(humidity.getValue());
            }
        });

        liveDataViewModel.getLiveTemperature().observe(this, temperature -> {
            if(temperature != null){
                textLiveTemperature.setText(temperature.getValue());
            }
        });

        liveDataViewModel.getLiveTimestamp().observe(this, timestamp -> {
            if(timestamp != null){
                textLiveTimestamp.setText(timestamp);
            }
        });
    }

    private void subscribeWebServiceObservers(){
        measurementViewModel.getAllCo2s().observe(this, co2List -> {
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

        measurementViewModel.getAllHumidities().observe(this, humidityList -> {
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

        measurementViewModel.getAllTemperatures().observe(this, temperatureList -> {
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

    private void temporaryButtons(){
        fragmentView.findViewById(R.id.button_get_co2_all)
                .setOnClickListener((View v) -> measurementViewModel.searchAllCo2s());

        fragmentView.findViewById(R.id.button_get_humidity_all2)
                .setOnClickListener((View v) -> measurementViewModel.searchAllHumidities());

        fragmentView.findViewById(R.id.button_get_temperature_all)
                .setOnClickListener((View v) -> measurementViewModel.searchAllTemperatures());
    }

}
