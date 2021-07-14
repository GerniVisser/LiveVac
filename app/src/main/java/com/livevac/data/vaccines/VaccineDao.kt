package com.livevac.data.vaccines

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VaccineDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVaccine(vaccine: Vaccine)

    @Query("SELECT * FROM vaccine_table")
    fun getAll(): LiveData<List<Vaccine>>

    @Transaction
    @Query("SELECT * FROM vaccine_table")
    fun getAllVaccinesWithDosage(): LiveData<List<VaccineWithDosage>>
}