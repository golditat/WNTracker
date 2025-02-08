package com.example.core.data.local.utils

enum class Muscle(val id: Int, val displayName: String, val isFront: Boolean, val imageUrlMain: String, val imageUrlSecondary: String) {
    SHOULDERS(2, "Shoulders", true, "/static/images/muscles/main/muscle-2.svg", "/static/images/muscles/secondary/muscle-2.svg"),
    ERROR(404, "ERROR", false, "", ""),
    BICEPS(1, "Biceps", true, "/static/images/muscles/main/muscle-1.svg", "/static/images/muscles/secondary/muscle-1.svg"),
    HAMSTRINGS(11, "Hamstrings", false, "/static/images/muscles/main/muscle-11.svg", "/static/images/muscles/secondary/muscle-11.svg"),
    BRACHIALIS(13, "Brachialis", true, "/static/images/muscles/main/muscle-13.svg", "/static/images/muscles/secondary/muscle-13.svg"),
    CALVES(7, "Calves", false, "/static/images/muscles/main/muscle-7.svg", "/static/images/muscles/secondary/muscle-7.svg"),
    GLUTES(8, "Glutes", false, "/static/images/muscles/main/muscle-8.svg", "/static/images/muscles/secondary/muscle-8.svg"),
    LATS(12, "Lats", false, "/static/images/muscles/main/muscle-12.svg", "/static/images/muscles/secondary/muscle-12.svg"),
    OBLIQUES(14, "Obliques", true, "/static/images/muscles/main/muscle-14.svg", "/static/images/muscles/secondary/muscle-14.svg"),
    CHEST(4, "Chest", true, "/static/images/muscles/main/muscle-4.svg", "/static/images/muscles/secondary/muscle-4.svg"),
    QUADS(10, "Quads", true, "/static/images/muscles/main/muscle-10.svg", "/static/images/muscles/secondary/muscle-10.svg"),
    ABS(6, "Abs", true, "/static/images/muscles/main/muscle-6.svg", "/static/images/muscles/secondary/muscle-6.svg"),
    SERRATUS_ANTERIOR(3, "Serratus Anterior", true, "/static/images/muscles/main/muscle-3.svg", "/static/images/muscles/secondary/muscle-3.svg"),
    SOLEUS(15, "Soleus", false, "/static/images/muscles/main/muscle-15.svg", "/static/images/muscles/secondary/muscle-15.svg"),
    TRAPEZIUS(9, "Trapezius", false, "/static/images/muscles/main/muscle-9.svg", "/static/images/muscles/secondary/muscle-9.svg"),
    TRICEPS(5, "Triceps", false, "/static/images/muscles/main/muscle-5.svg", "/static/images/muscles/secondary/muscle-5.svg");

    companion object {
        fun fromId(id: Int) = values().find { it.id == id }?:ERROR
        fun fromName(name:String) = values().find { it.displayName == name } ?: ERROR
    }
}