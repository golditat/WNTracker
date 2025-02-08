package com.example.core.data.local.utils

enum class Equipment(val id: Int, val displayName: String) {
    BARBELL(1, "Barbell"),
    BENCH(8, "Bench"),
    DUMBBELL(3, "Dumbbell"),
    GYM_MAT(4, "Gym Mat"),
    INCLINE_BENCH(9, "Incline Bench"),
    KETTLEBELL(10, "Kettlebell"),
    PULL_UP_BAR(6, "Pull-up Bar"),
    SZ_BAR(2, "SZ-Bar"),
    SWISS_BALL(5, "Swiss Ball"),
    ERROR(404, "ERROR"),
    BODYWEIGHT(7, "Bodyweight Exercise");

    companion object {
        fun fromId(id: Int) = values().find { it.id == id }?:ERROR
        fun fromName(name:String) = values().find{ it.displayName == name} ?: ERROR
    }
}