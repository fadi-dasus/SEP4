package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.MainActivity;
import com.example.sensorsproject.business.models.MyRoom;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.nitri.gauge.Gauge;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomMainFragment extends Fragment {

    private ArrayAdapter<MyRoom> spinnerAdapter;

    @BindView(R.id.spinner_main) Spinner mainSpinner;
    @BindView(R.id.room_textView_main) TextView mainRoomTextView;
    @BindView(R.id.co2_main_textView) TextView co2mainTextView;
    @BindView(R.id.temp_main_textView) TextView tempMainTextView;
    @BindView(R.id.hum_main_textView) TextView humMainTextView;
    @BindView(R.id.nextFragmentBtn) Button nextFragmentBtn;
    @BindView(R.id.co2_main_logo) ImageView co2MainLogoView;
    @BindView(R.id.temp_main_logo) ImageView tempMainLogoView;
    @BindView(R.id.hum_main_logo) ImageView humMaimLogoView;
    @BindView(R.id.reset) Button reset;
    @BindView(R.id.startBtn) Button start;
    public RoomMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize spinner adapter
        spinnerAdapter = new ArrayAdapter<MyRoom>(getContext(), android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_main, container, false);
        ButterKnife.bind(this, view);

        //setting spinner adapter
        mainSpinner.setAdapter(spinnerAdapter);
        mainRoomTextView.setText("Room1");
        co2mainTextView.setText("400 ppm");
        tempMainTextView.setText("27 C");
        humMainTextView.setText("72%");
        final Gauge gauge = view.findViewById(R.id.gauge);

        gauge.setNeedleStepFactor(10f);
        gauge.setDeltaTimeInterval(1);
        nextFragmentBtn.setOnClickListener(v ->
                MainActivity.navController.navigate(R.id.action_roomMainFragment_to_reportListFragment));

        reset.setOnClickListener(v ->
                gauge.moveToValue(0));

        start.setOnClickListener(v ->
                gauge.moveToValue(400));

        tempMainLogoView.setOnClickListener(v -> {
            gauge.setLowerText("C");
            gauge.setMaxValue(50);
            gauge.setMinValue(-50);
            gauge.setUpperText("Temperature");
            gauge.setUpperTextSize(35);
            gauge.setTotalNicks(120);
            gauge.setValuePerNick(1);
            gauge.setValue(27);
        });

        co2MainLogoView.setOnClickListener(v -> {
            gauge.setLowerText("ppm");
            gauge.setMaxValue(600);
            gauge.setMinValue(-200);
            gauge.setUpperText("CO2");
            gauge.setUpperTextSize(50);
            gauge.setTotalNicks(90);
            gauge.setValuePerNick(10);
            gauge.setValue(400);
        });

        humMaimLogoView.setOnClickListener(v -> {
            gauge.setLowerText("%");
            gauge.setMaxValue(100);
            gauge.setMinValue(0);
            gauge.setUpperText("Humidity");
            gauge.setUpperTextSize(35);
            gauge.setTotalNicks(120);
            gauge.setValuePerNick(1);
            gauge.setValue(72);
        });

        return view;
    }



}
