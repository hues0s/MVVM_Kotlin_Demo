package com.example.apirestdemohector.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.apirestdemohector.model.models.Photo
import com.example.apirestdemohector.viewModel.repositories.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShowOneViewModel(application: Application) : AndroidViewModel(application) {

    private val photoRepository = PhotoRepository.getInstance(application)

    val isPhotoLoadingLiveData = MutableLiveData<Boolean>()

    fun photoLiveData(id: Int): LiveData<Photo?> = liveData(Dispatchers.IO) {
        withContext(Dispatchers.Main) {
            isPhotoLoadingLiveData.value = true
        }
        emitSource(photoRepository.getPhotoByIdLiveData(id))
        withContext(Dispatchers.Main) {
            isPhotoLoadingLiveData.value = false
        }
    }

}