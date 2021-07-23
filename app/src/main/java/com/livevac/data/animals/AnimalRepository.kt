package com.livevac.data.animals

import androidx.lifecycle.LiveData
import com.livevac.data.Herd.Herd
import com.livevac.data.Herd.HerdDao

class AnimalRepository (private val animalDao: AnimalDao, private val herdDao: HerdDao) {

    val readAllData: LiveData<List<Animal>> = animalDao.getAll()
    val getAllHerds: LiveData<List<Herd>> = herdDao.getAll()

    suspend fun addAnimal(animal: Animal){
        animalDao.addAnimal(animal)
    }

    suspend fun addHerd(herd: Herd){
        herdDao.addHerd(herd)
    }
}