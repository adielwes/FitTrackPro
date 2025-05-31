package com.wesleyadiel.fitnesstrackpro.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wesleyadiel.fitnesstrackpro.database.bodystats.BodyStatsDao
import com.wesleyadiel.fitnesstrackpro.database.bodystats.BodyStatsEntity

@Database(entities = [BodyStatsEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bodyStatsDao(): BodyStatsDao
}