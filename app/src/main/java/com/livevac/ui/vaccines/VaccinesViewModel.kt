package com.livevac.ui.vaccines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VaccinesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is vaccines Fragment"
    }
    val text: LiveData<String> = _text
}