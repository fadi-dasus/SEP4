package com.example.sensorsproject.application.views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.viewmodels.ListViewModel;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class WarningListFragment extends Fragment {

    private LiveDataViewModel liveDataViewModel;
    private ListViewModel listViewModel;


    public WarningListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
        listViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);

        String roomId = liveDataViewModel.getCurrentRoom().getValue().getId();
        listViewModel.searchAllWarningsByRoomId(roomId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warning_list, container, false);

        TextView textView = view.findViewById(R.id.myTextView);

        textView.setOnClickListener((View v) -> {
            Toast.makeText(getActivity(), listViewModel.getAllWarningsByRoomId().getValue().get(0).toString(), Toast.LENGTH_SHORT).show();
        });

        return view;
    }

}
