package com.example.rikki.livedataviewmodeldemo

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var userName : MutableLiveData<String> = MutableLiveData()
    var password : MutableLiveData<String> = MutableLiveData()
    val validator = MediatorLiveData<Boolean>()

    init {
        validator.addSource(userName) { validateForm() }
        validator.addSource(password) { validateForm() }
    }

    private fun validateForm() {
        validator.value = !userName.value.isNullOrBlank() && !password.value.isNullOrBlank()
    }
}