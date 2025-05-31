package com.wesleyadiel.fitnesstrackpro.database.inject

import android.content.Context
import androidx.room.Room
import com.wesleyadiel.fitnesstrackpro.database.AppDatabase
import com.wesleyadiel.fitnesstrackpro.database.bodystats.BodyStatsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration(true)
            .build()

    @Provides
    fun provideBodyStatsDao(db: AppDatabase): BodyStatsDao = db.bodyStatsDao()

    private const val DATABASE_NAME = "fitness_track_pro_db"
}