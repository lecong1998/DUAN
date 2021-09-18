package com.example.movieapp.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TopMoviesResponse {
    @Expose
    @SerializedName("items")
    val topMovies: List<TopMovie>? = null
}
