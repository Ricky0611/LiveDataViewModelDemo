package com.example.rikki.livedataviewmodeldemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {

    private MutableLiveData<String> name;

    public MutableLiveData<String> getName(){
        if(name == null){
            name = new MutableLiveData<String>();
        }
        return name;
    }

}
