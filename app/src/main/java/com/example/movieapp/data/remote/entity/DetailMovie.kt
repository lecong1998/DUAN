package com.example.movieapp.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DetailMovie(
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
    @SerializedName("releaseDate")
    val releaseDate: String,
    @Expose
    @SerializedName("plot")
    val plot: String,
    @Expose
    @SerializedName("directors")
    val directors: String,
    @Expose
    @SerializedName("starList")
    val actorList: ArrayList<Actor>,
    @Expose
    @SerializedName("genres")
    val genres: String,
    @Expose
    @SerializedName("countries")
    val countries: String
): Serializable