package com.example.sensorsproject.application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.viewmodels.LiveDataViewModel;
import com.example.sensorsproject.business.models.MyRoom;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static NavController navController;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.bottom_nav) BottomNavigationView bottomNav;

    private MenuItem logoutItem;
    private MenuItem todayDataItem;

    private LiveDataViewModel liveDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Set up ViewModel
        liveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel.class);

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Setup NavController
        navController = Navigation.findNavController(this, R.id.nav_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.loginFragment, R.id.roomChoiceFragment, R.id.roomMainFragment, R.id.reportListFragment, R.id.warningListFragment).build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNav, navController);
        navController.addOnDestinationChangedListener(navDestinationListener());
    }

    private NavController.OnDestinationChangedListener navDestinationListener(){
        return new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.roomMainFragment){
                    setUiVisible(true);
                } else if(destination.getId() == R.id.reportListFragment){
                    setUiVisible(true);
                } else if(destination.getId() == R.id.warningListFragment){
                    setUiVisible(true);
                } else if(destination.getId() == R.id.loginFragment) {
                    setUiVisible(false);
                } else if(destination.getId() == R.id.roomChoiceFragment){
                    setUiVisible(false);
                } else if(destination.getId() == R.id.todayDataFragment){
                    bottomNav.setVisibility(View.GONE);
                } else if(destination.getId() == R.id.action_today_data){
                    bottomNav.setVisibility(View.GONE);
                }
            }
        };
    }

    private void setUiVisible(boolean mVisibility){
        if(mVisibility){
            bottomNav.setVisibility(View.VISIBLE);
            if(logoutItem != null && todayDataItem != null){
                logoutItem.setVisible(true);
                todayDataItem.setVisible(true);
            }
        } else {
            bottomNav.setVisibility(View.GONE);
            if(logoutItem != null && todayDataItem != null){
                logoutItem.setVisible(false);
                todayDataItem.setVisible(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        todayDataItem = menu.findItem(R.id.action_today_data);
        logoutItem = menu.findItem(R.id.action_logout);
        todayDataItem.setVisible(false);
        logoutItem.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id){
            case R.id.action_today_data: {
                navController.navigate(R.id.action_global_todayDataFragment);
            }

            case R.id.action_logout: {
                navController.navigate(R.id.action_global_loginFragment);
                FirebaseAuth.getInstance().signOut();
            }

            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(liveDataViewModel.getCurrentRoom().getValue() != null){
            MyRoom room;
            room = liveDataViewModel.getCurrentRoom().getValue();
            liveDataViewModel.subscribe(room);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(liveDataViewModel.getCurrentRoom().getValue() != null){
            String roomName;
            roomName = liveDataViewModel.getCurrentRoom().getValue().getRoomName();
            liveDataViewModel.unsubscribe(roomName);
        }
    }

    @Override
    protected void onDestroy() {
        FirebaseAuth.getInstance().signOut();
        super.onDestroy();
    }
}
