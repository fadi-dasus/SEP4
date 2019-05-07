package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        final Gauge gauge = view.findViewById(R.id.gauge);

        Button button = view.findViewById(R.id.button3);

        button.setOnClickListener((View v) -> {
            MainActivity.navController.navigate(R.id.action_roomMainFragment_to_reportListFragment);
        });

        return view;
    }

}
