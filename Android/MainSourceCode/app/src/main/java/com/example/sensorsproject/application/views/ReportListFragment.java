package com.example.sensorsproject.application.views;


import android.icu.util.Measure;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.viewmodels.MeasurementViewModel;
import com.example.sensorsproject.business.models.CO2;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportListFragment extends Fragment {


    private MeasurementViewModel measurementViewModel;

    public ReportListFragment() {
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
        View view = inflater.inflate(R.layout.fragment_report_list, container, false);
        ButterKnife.bind(this, view);

        Button button = view.findViewById(R.id.button_get_one_co2);
        button.setOnClickListener((View v) -> {
            measurementViewModel.searchOneHumidity("1");
        });

        subscribeObservers();

        return view;
    }

    private void subscribeObservers(){
        measurementViewModel.getOneHumidity().observe(this, co2 -> {
            if(co2 != null){
                Toast.makeText(getActivity(), co2.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
