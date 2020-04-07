package com.tushar.viewstubviewpager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val name = MutableLiveData<String>("")
    val address = MutableLiveData<String>("")
    val contact = MutableLiveData<String>("")
    val email = MutableLiveData<String>("")
    val pincode = MutableLiveData<String>("")
}