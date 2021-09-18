package com.example.movieapp.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VideoTrailer(
    @Expose
    @SerializedName("imDbId")
    val movieid: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("videoId")
    val videoId: String,
    @Expose
    @SerializedName("videoUrl")
    val videoUrl: String,
): Serializable
