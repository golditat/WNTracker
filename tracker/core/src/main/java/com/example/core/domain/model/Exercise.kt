package com.example.core.domain.model

import com.example.core.data.local.utils.Categories
import com.example.core.data.local.utils.Equipment
import com.example.core.data.local.utils.Muscle

data class Exercise (
    val id: Int,
    val name: String,
    val description: String,
    val category: Categories,
    val muscles: List<Muscle>,
    val equipment: List<Equipment>
)