package com.example.sensorsproject.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sensorsproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static NavController navController;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Setup NavController
        navController = Navigation.findNavController(this, R.id.nav_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.loginFragment, R.id.roomChoiceFragment, R.id.roomMainFragment).build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }
}
