package com.livevac.ui.herd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HerdViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is herd Fragment"
    }
    val text: LiveData<String> = _text
}