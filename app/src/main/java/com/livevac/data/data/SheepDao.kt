package com.livevac.data.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SheepDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSheep(sheep: Sheep)

    @Query("SELECT * FROM sheep_table")
    fun getAll(): List<Sheep>
}