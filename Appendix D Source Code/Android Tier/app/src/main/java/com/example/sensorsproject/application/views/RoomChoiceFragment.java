package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.MainActivity;
import com.example.sensorsproject.application.adapters.RoomChoiceAdapter;
import com.example.sensorsproject.application.viewmodels.ListViewModel;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.business.models.MyRoom;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomChoiceFragment extends Fragment implements RoomChoiceAdapter.OnRoomListener {

    private ListViewModel listViewModel;

    @BindView(R.id.room_choice_recyclerview)
    RecyclerView mRecyclerView;
    private RoomChoiceAdapter mAdapter;
    private ListViewModel mMainActivityViewModel;
    private LiveDataViewModel liveDataViewModel;

    public RoomChoiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize view models
        listViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);
        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_choice, container, false);
        ButterKnife.bind(this, view);


        mMainActivityViewModel = ViewModelProviders.of(this).get(ListViewModel.class);

        mMainActivityViewModel.getAllRooms().observe(this, new Observer<List<MyRoom>>() {

            //override
            public void onChanged(@Nullable List<MyRoom> myRoomList) {
                if (myRoomList != null)
                {
                    mAdapter.updateRoomList(myRoomList);
                    String roomName = "";
                    for(int i = 0; i < myRoomList.size(); i++){
                        roomName = myRoomList.get(i).getRoomName();
                        liveDataViewModel.unsubscribe(roomName);
                    }
                }

            }
        });
        initRecyclerView();

        //Initialize all rooms in MutableLiveData from web services
        mMainActivityViewModel.searchAllRooms();
        return view;
    }

    private void initRecyclerView()
    {
        mAdapter = new RoomChoiceAdapter(getContext(), this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    //Implements on room click
    @Override
    public void onRoomClick(int position) {
        MyRoom currentRoom = mAdapter.getRoomById(position);

        //Todo: When I will move subscribe to setCurrentRoom remove it from here
        liveDataViewModel.subscribe(currentRoom);
        MainActivity.navController.navigate(R.id.action_roomChoiceFragment_to_roomMainFragment);
    }
}