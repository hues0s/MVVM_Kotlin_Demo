package com.example.apirestdemohector.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.apirestdemohector.model.models.Photo

@Dao
interface PhotoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: Photo)

    @Query("SELECT * FROM photo_table")
    fun getAllPhotosLiveData(): LiveData<List<Photo>>

    @Query("SELECT * FROM photo_table WHERE id = :photoId")
    fun getPhotoByIdLiveData(photoId: Int): LiveData<Photo?>
}
