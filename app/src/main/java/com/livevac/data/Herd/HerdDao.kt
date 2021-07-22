package com.livevac.data.Herd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.livevac.data.animals.Animal

@Dao
interface HerdDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHerd(herd: Herd)

    @Query("SELECT * FROM herd_table")
    fun getAll(): LiveData<List<Herd>>
}