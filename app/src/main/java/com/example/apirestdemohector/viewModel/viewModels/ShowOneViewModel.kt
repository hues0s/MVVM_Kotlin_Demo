package com.example.apirestdemohector.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.apirestdemohector.model.models.Photo
import com.example.apirestdemohector.viewModel.repositories.PhotoRepository
import kotlinx.coroutines.Dispatchers

class ShowOneViewModel(application: Application) : AndroidViewModel(application) {

    private val photoRepository = PhotoRepository.getInstance(application)

    fun photoLiveData(id: Int): LiveData<Photo?> = liveData(Dispatchers.IO) {
        emitSource(photoRepository.getPhotoByIdLiveData(id))
    }

}