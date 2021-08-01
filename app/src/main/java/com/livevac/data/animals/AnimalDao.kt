package com.livevac.data.animals

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDao {
    //Insert Animal to DB
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAnimal(animal: Animal)

    @Query("SELECT * FROM animal_table")
    fun getAll(): LiveData<List<Animal>>


}
//passed