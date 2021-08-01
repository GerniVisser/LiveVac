package com.livevac.data.animals

import androidx.lifecycle.LiveData
//import com.livevac.data.herd.Herd
//import com.livevac.data.herd.HerdDao

class AnimalRepository (private val animalDao: AnimalDao) {

    val readAllData: LiveData<List<Animal>> = animalDao.getAll()
    //val getAllHerds: LiveData<List<Herd>> = herdDao.getAll()

    suspend fun addAnimal(animal: Animal){
        animalDao.addAnimal(animal)
    }

    /*suspend fun addHerd(herd: Herd){
        herdDao.addHerd(herd)
    }*/
}