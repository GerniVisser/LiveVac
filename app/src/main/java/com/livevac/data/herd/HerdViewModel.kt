package com.livevac.data.herd

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.livevac.data.DataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HerdViewModel (application: Application): AndroidViewModel(application){
    private val readAllData: LiveData<List<Herd>>
    private val repository: HerdRepository

    init {
        val herdDao = DataBase.getDatabase(application).herdDao()
        repository = HerdRepository(herdDao)
        readAllData = repository.getAllHerds
    }

    fun addHerd(herd: Herd){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHerd(herd)
        }
    }

}
