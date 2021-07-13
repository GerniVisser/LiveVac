package com.livevac.data.dosage

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "dosage_table")
data class Dosage(
    @PrimaryKey(autoGenerate = true)
    val dosageId: Int,
    val vacId: Int,
    val gender: String,
    val LifeStage: Int,
    val Repeated: Boolean,
    val intervalDays: Int,
)