package com.livevac.data.herd

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HerdDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHerd(herd: Herd)

    @Query("SELECT * FROM herd_table")
    fun getAll(): LiveData<List<Herd>>

    @Transaction
    @Query("SELECT * FROM animal_table")
    fun getAllHerdWithAnimal(): LiveData<List<HerdAnimalRelation>>
}