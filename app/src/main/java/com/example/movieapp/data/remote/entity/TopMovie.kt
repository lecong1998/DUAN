package com.example.movieapp.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TopMovie(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("year")
    val year: String,
    @Expose
    @SerializedName("image")
    val image: String,
    @Expose
    @SerializedName("imDbRating")
    val imDbRating: String
): Serializable
