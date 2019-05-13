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
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.adapters.WarningListAdapter;
import com.example.sensorsproject.application.viewmodels.ListViewModel;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.business.models.Warning;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WarningListFragment extends Fragment {

    @BindView(R.id.rv_warning_list)
    RecyclerView recyclerView;

    @BindView(R.id.warning_room_name)
    TextView textRoomName;

    private LiveDataViewModel liveDataViewModel;
    private ListViewModel listViewModel;
    private WarningListAdapter adapter;
    private String roomName;

    public WarningListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
        listViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);

        String roomId = liveDataViewModel.getCurrentRoom().getValue().getId();
        roomName = liveDataViewModel.getCurrentRoom().getValue().getRoomName();
        listViewModel.searchAllWarningsByRoomId(roomId);

        adapter = new WarningListAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warning_list, container, false);
        ButterKnife.bind(this, view);

        //Init recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        textRoomName.setText(roomName);

        subscribeObservers();

        return view;
    }

    public void subscribeObservers(){
        listViewModel.getAllWarningsByRoomId().observe(this, warnings -> {
            if(warnings != null && warnings.size() > 0){
                adapter.setWarningList(warnings);
            }
        });
    }

}
