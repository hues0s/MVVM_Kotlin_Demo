package com.example.apirestdemohector.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apirestdemohector.model.database.daos.PhotoDAO
import com.example.apirestdemohector.model.models.Photo
import com.example.apirestdemohector.utils.ROOM_DB_NAME

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun getPhotoDAO(): PhotoDAO

    companion object {
        private var INSTANCE: RoomDB? = null

        fun getDatabase(context: Context) = INSTANCE ?: kotlin.run {
            Room.databaseBuilder(
                context.applicationContext,
                RoomDB::class.java,
                ROOM_DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
