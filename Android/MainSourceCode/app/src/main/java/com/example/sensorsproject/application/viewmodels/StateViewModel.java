package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel {

    private MutableLiveData<Boolean> isLogin;

    public StateViewModel(){
        isLogin = new MutableLiveData<>();
        isLogin.postValue(false);
    }
}
