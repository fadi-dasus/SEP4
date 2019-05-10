package com.example.sensorsproject.application.views;


import android.icu.util.Measure;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.viewmodels.MeasurementViewModel;

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

    public TodayDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        measurementViewModel = ViewModelProviders.of(getActivity()).get(MeasurementViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_data, container, false);
        ButterKnife.bind(this, view);

        setOnClickListeners();

        return view;
    }

    private void setOnClickListeners(){

        buttonCo2.setOnClickListener(v -> {

        });

        buttonHum.setOnClickListener(v -> {

        });

        buttonTemp.setOnClickListener(v -> {

        });
    }

}
