package com.livevac.data.animals

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.livevac.data.DataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AnimalViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Animal>>
    private val repository: AnimalRepository

    init {
        val animalDao = DataBase.getDatabase(application).animalDao()
        //val herdDao = DataBase.getDatabase(application).herdDao()
        repository = AnimalRepository(animalDao)
        readAllData = repository.readAllData
    }

    fun addAnimal(animal: Animal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAnimal(animal)
        }
    }

}