package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.MainActivity;
import com.example.sensorsproject.application.viewmodels.ListViewModel;
import com.example.sensorsproject.business.models.MyRoom;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomChoiceFragment extends Fragment {

    private ListViewModel listViewModel;
    private ArrayAdapter<MyRoom> spinnerAdapter;

    @BindView(R.id.room_spinner) Spinner roomSpinner;

    public RoomChoiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize view models
        listViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);

        //Initialize Spinner adapter
        spinnerAdapter = new ArrayAdapter<MyRoom>(getContext(), android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_choice, container, false);
        ButterKnife.bind(this, view);

        //After views are binded, set spinner adapter
        roomSpinner.setAdapter(spinnerAdapter);

        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener((View v) -> {
            MainActivity.navController.navigate(R.id.action_roomChoiceFragment_to_roomMainFragment);
        });

        Button buttonGetRooms = view.findViewById(R.id.btn_get_room);
        buttonGetRooms.setOnClickListener((View v) -> {
            listViewModel.searchAllRooms();
        });

        subscribeObservers();

        return view;
    }

    private void subscribeObservers(){
        listViewModel.getAllRooms().observe(this, myRooms -> {
            if(myRooms != null){
                if(myRooms.size() > 0){
                    Toast.makeText(getActivity(), "RoomID: " + myRooms.get(0).getId(), Toast.LENGTH_SHORT).show();
                    spinnerAdapter.clear();
                    spinnerAdapter.addAll(myRooms);
                    spinnerAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}