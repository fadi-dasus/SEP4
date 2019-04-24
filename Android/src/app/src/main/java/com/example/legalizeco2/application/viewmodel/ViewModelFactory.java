package com.example.legalizeco2.application.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.legalizeco2.business.data.repository.ListRepository;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final ListRepository listRepository;

    public ViewModelFactory(ListRepository listRepository){
        this.listRepository = listRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new ListViewModel(listRepository);
    }
}
