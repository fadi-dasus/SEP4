package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.models.Warning;
import com.example.sensorsproject.business.repositories.ListRepository;

import java.util.List;

public class ListViewModel extends ViewModel {

    private ListRepository repository;

    public ListViewModel(){
        repository = ListRepository.getInstance();
    }

    /*
     * GET LIVE DATA
     */

    public LiveData<List<MyRoom>> getAllRooms(){return repository.getAllRooms(); }

    public LiveData<List<Warning>> getAllWarningsByRoomId() {return repository.getAllWarnings();}

    /*
     * UPDATE LIVE DATA
     */

    public void searchAllRooms(){repository.searchAllRooms();}

    public void searchAllWarningsByRoomId(String roomId) {repository.searchAllWarningsByRoomId(roomId);}

}
