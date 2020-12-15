package com.example.apirestdemohector.api

import com.example.apirestdemohector.model.models.Photo
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoEndpoints {

    @GET("photos/")
    suspend fun getPhotoList(): List<Photo>

    @GET("photos/{photoId}")
    suspend fun getPhotoById(@Path("photoId") photoId: Int): Photo
}
