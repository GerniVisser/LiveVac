package com.livevac.data.vaccines

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "vaccine_table")
data class Vaccine(
    @PrimaryKey(autoGenerate = true)
    val vacId: Int,
    val name: String,
    val description: String,
    val image: ByteArray,
)