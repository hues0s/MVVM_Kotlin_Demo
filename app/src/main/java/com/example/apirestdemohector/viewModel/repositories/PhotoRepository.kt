package com.example.apirestdemohector.viewModel.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.apirestdemohector.api.PhotoEndpoints
import com.example.apirestdemohector.api.RetroFitInstance
import com.example.apirestdemohector.model.database.RoomDB
import com.example.apirestdemohector.model.database.daos.PhotoDAO
import com.example.apirestdemohector.model.models.Photo
import timber.log.Timber

class PhotoRepository private constructor(application: Application) {

    companion object {

        private var INSTANCE: PhotoRepository? = null

        fun getInstance(application: Application): PhotoRepository = INSTANCE ?: kotlin.run {
            INSTANCE = PhotoRepository(application = application)
            INSTANCE!!
        }

    }

    private val photoDAO: PhotoDAO = RoomDB.getDatabase(application).getPhotoDAO()
    private val photoAPICalls = RetroFitInstance.getInstance().create(PhotoEndpoints::class.java)

    private fun insertPhoto(photo: Photo) {
        photoDAO.insertPhoto(photo)
    }

    suspend fun getAllPhotosLiveData(): LiveData<List<Photo>> {
        return photoDAO.getAllPhotosLiveData().also {
            getAllPhotosFromRemote()
        }
    }

    private suspend fun getAllPhotosFromRemote() {
        try {
            val photoList = photoAPICalls.getPhotoList()
            photoList.forEach {
                insertPhoto(it)
            }
        } catch (exception: Throwable) {
            Timber.e(exception)
        }
    }

    suspend fun getPhotoByIdLiveData(photoId: Int): LiveData<Photo?> {
        return photoDAO.getPhotoByIdLiveData(photoId).also {
            try {
                val photo = photoAPICalls.getPhotoById(photoId)
                insertPhoto(photo)
            } catch (exception: Throwable) {
                Timber.e(exception)
            }
        }
    }

}