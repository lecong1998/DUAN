package com.example.movieapp.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FilmSearch(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("image")
    val image: String,
    @Expose
    @SerializedName("description")
    val description: String,
)
