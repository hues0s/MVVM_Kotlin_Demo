package com.example.apirestdemohector.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.apirestdemohector.model.models.Photo
import com.example.apirestdemohector.viewModel.repositories.PhotoRepository
import kotlinx.coroutines.Dispatchers

class ShowAllViewModel(application: Application) : AndroidViewModel(application) {

    private val photoRepository = PhotoRepository.getInstance(application)

    val photoListLiveData: LiveData<List<Photo>> = liveData(Dispatchers.IO) {
        emitSource(photoRepository.getAllPhotosLiveData())
    }

}