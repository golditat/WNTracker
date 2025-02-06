package com.example.core.data.mapper

import com.example.core.data.local.entity.ExerciseEntity
import com.example.core.data.local.utils.Categories
import com.example.core.data.local.utils.Equipment
import com.example.core.data.local.utils.Muscle
import com.example.core.data.remote.dto.ExerciseDTO
import com.example.core.domain.model.Exercise

fun ExerciseDTO.toEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        category = Categories.fromId(this.categoryId)?.displayName?:"ERROR",
        muscles = this.muscles.joinToString(","),
        equipment = this.equipment.joinToString(",")
    )
}

fun ExerciseEntity.toDomain(): Exercise {
    return Exercise(
        id = this.id,
        name = this.name,
        description = this.description,
        category = Categories.fromId(Integer.parseInt(this.category)),
        muscles = this.muscles.split(",").map{muscles->
            Muscle.fromId(Integer.parseInt(muscles))
        },
        equipment = this.equipment.split(",").map { equipment->
            Equipment.fromId(Integer.parseInt(equipment))
        }
    )
}

fun ExerciseDTO.toDomain(): Exercise {
    return Exercise(
        id = this.id,
        name = this.name,
        description = this.description,
        category = Categories.fromId(this.categoryId),
        muscles = this.muscles.map { muscles->
            Muscle.fromId(muscles)
        },
        equipment = this.equipment.map { equipment->
            Equipment.fromId(equipment)
        }
    )
}