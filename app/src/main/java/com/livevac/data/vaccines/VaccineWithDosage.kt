package com.livevac.data.vaccines

import androidx.room.Embedded
import androidx.room.Relation
import com.livevac.data.dosage.Dosage


data class VaccineWithDosage(
    @Embedded val vaccine: Vaccine,
    @Relation(
        parentColumn = "vacId",
        entityColumn = "dosageId"
    )
    val dosage: List<Dosage>
)