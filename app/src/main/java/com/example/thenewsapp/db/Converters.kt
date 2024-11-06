package com.example.thenewsapp.db

import androidx.room.TypeConverter
import com.example.thenewsapp.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source?): String? {
        // Return the name if available, else return null
        return source?.name
    }

    @TypeConverter
    fun toSource(name: String?): Source {
        // Use name for both `id` and `name` fields if not null, otherwise set both as null
        return Source(id = name, name = name)
    }
}
