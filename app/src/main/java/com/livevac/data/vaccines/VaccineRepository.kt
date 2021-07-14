package com.livevac.data.vaccines

import androidx.lifecycle.LiveData

class VaccineRepository(private val vaccineDao: VaccineDao) {

    val readAllData: LiveData<List<Vaccine>> = vaccineDao.getAll()

    suspend fun addVaccine(vaccine: Vaccine){
        vaccineDao.addVaccine(vaccine)
    }
}