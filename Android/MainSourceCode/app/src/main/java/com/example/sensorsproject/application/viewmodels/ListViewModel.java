package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sensorsproject.business.models.MyRoom;
import com.example.sensorsproject.business.repositories.ListRepository;

import java.util.List;

public class ListViewModel extends ViewModel {

    private ListRepository repository;

    public ListViewModel(){
        repository = ListRepository.getInstance();
    }

    public LiveData<List<MyRoom>> getAllRooms(){
        return repository.getAllRooms();
    }

    public void searchAllRooms(){
        repository.searchAllRooms();
    }

}
