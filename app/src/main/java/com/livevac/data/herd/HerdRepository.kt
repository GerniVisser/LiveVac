package com.livevac.data.herd

import androidx.lifecycle.LiveData
import com.livevac.data.herd.Herd
import com.livevac.data.herd.HerdDao
import com.livevac.data.animals.Animal
import com.livevac.data.animals.AnimalDao

class HerdRepository ( private val herdDao: HerdDao) {

    //val readAllData: LiveData<List<Animal>> = animalDao.getAll()
    val getAllHerds: LiveData<List<Herd>> = herdDao.getAll()


    suspend fun addHerd(herd: Herd){
        herdDao.addHerd(herd)
    }
}