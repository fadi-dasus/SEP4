package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomChoiceFragment extends Fragment {


    public RoomChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_choice, container, false);

        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener((View v) -> {
            MainActivity.navController.navigate(R.id.action_roomChoiceFragment_to_roomMainFragment);
        });

        return view;
    }

}