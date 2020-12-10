package com.example.apirestdemohector.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.apirestdemohector.model.models.Photo

@Dao
interface PhotoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: Photo)

    @Delete
    fun deletePhoto(photo: Photo)

    @Query("SELECT * FROM photo_table")
    fun getAllPhotosLiveData(): LiveData<List<Photo>>

    @Query("SELECT * FROM photo_table WHERE id = :photoId")
    fun getPhotoByIdLiveData(photoId: Int): LiveData<Photo?>

}