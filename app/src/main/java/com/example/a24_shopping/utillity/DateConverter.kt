package com.example.a24_shopping.utillity

import androidx.room.TypeConverter
import java.util.*

object DateConverter {

    @TypeConverter
    fun toData(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }

    @TypeConverter
    fun fromData(date: Date?): Long? {
        return date?.time
    }
}