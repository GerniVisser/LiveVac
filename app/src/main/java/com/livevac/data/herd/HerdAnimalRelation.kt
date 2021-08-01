package com.livevac.data.herd

import androidx.room.Embedded
import androidx.room.Relation
import com.livevac.data.animals.Animal

data class HerdAnimalRelation(
    @Embedded val herd: Herd,
    @Relation(
        parentColumn = "herdId",
        entityColumn = "animalId"
    )
    val animal: List<Animal>
)