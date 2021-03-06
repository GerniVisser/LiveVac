package com.livevac.data.animals

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "animal_table")
data class Animal(
    @PrimaryKey(autoGenerate = true)
    val animalId: Int,
    val herdId: Int,
    //val identity: String,
    val name: String,
    val type: String,
    val breed: String,
    val gender: String,
    val dob: Long
)
//passed
