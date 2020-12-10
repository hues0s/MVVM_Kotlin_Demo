package com.example.apirestdemohector.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "photo_table")
data class Photo(
    @Expose
    @PrimaryKey
    val id: Int,
    @Expose
    val albumId: Int,
    @Expose
    val title: String,
    @Expose
    val url: String,
    @Expose
    val thumbnailUrl: String
)