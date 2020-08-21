package com.tomisztomek.kursakademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tomisztomek.kursakademiaandroida.features.character.data.local.CharacterDao
import com.tomisztomek.kursakademiaandroida.features.character.data.local.model.CharacterCached
import com.tomisztomek.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.tomisztomek.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.tomisztomek.kursakademiaandroida.features.location.data.local.LocationDao
import com.tomisztomek.kursakademiaandroida.features.location.data.local.model.LocationCached

const val DATABASE_NAME = "db_name"

@Database(
    entities = [EpisodeCached::class, CharacterCached::class, LocationCached::class],
    version = 1
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
    abstract fun characterDao(): CharacterDao
}