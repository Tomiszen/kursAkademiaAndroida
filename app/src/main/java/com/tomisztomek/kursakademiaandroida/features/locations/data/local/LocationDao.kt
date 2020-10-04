package com.tomisztomek.kursakademiaandroida.features.locations.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tomisztomek.kursakademiaandroida.features.locations.data.local.model.LocationCached

@Dao
interface LocationDao {

    @Query("SELECT * FROM LocationCached")
    suspend fun getLocations(): List<LocationCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg locations: LocationCached)
}