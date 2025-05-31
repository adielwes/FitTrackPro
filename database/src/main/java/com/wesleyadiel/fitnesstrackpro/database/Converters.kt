package com.wesleyadiel.fitnesstrackpro.database

import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {

    @TypeConverter
    fun LocalDate.toEpochDayLong(): Long = this.toEpochDay()

    @TypeConverter
    fun Long.toLocalDate(): LocalDate = LocalDate.ofEpochDay(this)
}