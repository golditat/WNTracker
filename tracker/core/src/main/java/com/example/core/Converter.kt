package com.example.core

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    private val gson = Gson()

    @TypeConverter
    fun fromListToString(equipment: List<Int>?): String {
        return gson.toJson(equipment)
    }

    @TypeConverter
    fun fromStringToList(equipmentString: String?): List<Int> {
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(equipmentString, type)
    }
}