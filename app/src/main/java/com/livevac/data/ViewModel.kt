package com.livevac.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.livevac.data.animals.Animal
import com.livevac.data.animals.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Animal>>
    private val repository: AnimalRepository

    init {
        val sheepDao = DataBase.getDatabase(application).AnimalDao()
        repository = AnimalRepository(sheepDao)
        readAllData = repository.readAllData
    }

    fun addSheep(animal: Animal){
        viewModelScope.launch(Dispatchers.IO){
            repository.addAnimal(animal)
        }
    }
}