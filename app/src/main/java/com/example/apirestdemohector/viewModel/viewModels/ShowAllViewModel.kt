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

class ShowAllViewModel(application: Application) : AndroidViewModel(application) {

    private val photoRepository = PhotoRepository.getInstance(application)

    //livedata used in order to show progressbar when the api is downloading data
    val arePhotosLoadingLiveData = MutableLiveData<Boolean>()

    val photoListLiveData: LiveData<List<Photo>> = liveData(Dispatchers.IO) {
        withContext(Dispatchers.Main) {
            arePhotosLoadingLiveData.value = true
        }
        emitSource(photoRepository.getAllPhotosLiveData())
        withContext(Dispatchers.Main) {
            arePhotosLoadingLiveData.value = false
        }
    }
}