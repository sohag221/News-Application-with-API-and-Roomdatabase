package com.example.thenewsapp.db

import androidx.room.TypeConverters
import com.example.thenewsapp.models.Source

class Converters {

    @TypeConverters
    fun fromSource(source: Source): String {
        return source.name
    }
    @TypeConverters
    fun toSource(name: String): Source {
        return Source(name, name)
    }

}