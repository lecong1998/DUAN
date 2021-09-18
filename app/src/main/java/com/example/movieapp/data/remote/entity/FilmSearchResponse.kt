package com.example.movieapp.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FilmSearchResponse {
    @Expose
    @SerializedName("results")
    val FilmSearchs: List<FilmSearch>? = null
}