package com.example.legalizeco2.application.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.legalizeco2.business.data.repository.ListRepository;
import com.example.legalizeco2.business.model.MyRoom;

import java.util.List;

public class ListViewModel extends ViewModel {

    private LiveData<List<MyRoom>> myRoomLiveData;
    private final ListRepository listRepository;

    public ListViewModel(ListRepository listRepository){
        this.listRepository = listRepository;
        myRoomLiveData = listRepository.getRoomList();
    }

    public LiveData<List<MyRoom>> getRoomList(){
        listRepository.refreshRoomList();
        return myRoomLiveData;
    }
}
