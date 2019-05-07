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
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button button = view.findViewById(R.id.login_button);
        button.setOnClickListener((View v) -> {
            MainActivity.navController.navigate(R.id.action_loginFragment_to_roomChoiceFragment);
        });

        return view;
    }

}
