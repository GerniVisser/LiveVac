package com.livevac.data.animals

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAnimal(animal: Animal)

    @Query("SELECT * FROM animal_table")
    fun getAll(): LiveData<List<Animal>>
}