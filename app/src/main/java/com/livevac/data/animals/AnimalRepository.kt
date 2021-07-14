package com.livevac.data.animals

import androidx.lifecycle.LiveData

class AnimalRepository(private val animalDao: AnimalDao) {

    val readAllData: LiveData<List<Animal>> = animalDao.getAll()

    suspend fun addAnimal(animal: Animal){
        animalDao.addAnimal(animal)
    }
}