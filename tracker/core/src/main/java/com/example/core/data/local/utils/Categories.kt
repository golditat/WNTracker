package com.example.core.data.local.utils

enum class Categories(val id: Int, val displayName: String) {
    ABS(10, "Abs"),
    ARMS(8, "Arms"),
    BACK(12, "Back"),
    CALVES(14, "Calves"),
    CARDIO(15, "Cardio"),
    CHEST(11, "Chest"),
    LEGS(9, "Legs"),
    ERROR(404, "ERROR"),
    SHOULDERS(13, "Shoulders");

    companion object {
        fun fromId(id: Int) = values().find { it.id == id }?:ERROR
        fun fromName(name:String) = values().find { it.displayName == name } ?: ERROR
    }
}