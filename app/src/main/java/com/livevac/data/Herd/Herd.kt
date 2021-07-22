package com.livevac.data.Herd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "herd_table")
data class Herd (
    @PrimaryKey(autoGenerate = true)
    val animalId: Int,
    val herdID: Int
)