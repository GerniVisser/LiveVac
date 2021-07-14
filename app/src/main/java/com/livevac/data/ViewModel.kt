package com.livevac.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.livevac.data.animals.Animal
import com.livevac.data.animals.AnimalRepository
import com.livevac.data.vaccines.Vaccine
import com.livevac.data.vaccines.VaccineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Vaccine>>
    private val repository: VaccineRepository

    init {
        val vaccineDao = DataBase.getDatabase(application).VaccineDao()
        repository = VaccineRepository(vaccineDao)
        readAllData = repository.readAllData
    }

    fun addVaccine(vaccine: Vaccine){
        viewModelScope.launch(Dispatchers.IO){
            repository.addVaccine(vaccine)
        }
    }
}