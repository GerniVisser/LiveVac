package com.livevac.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sheep_table")
data class Sheep(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)