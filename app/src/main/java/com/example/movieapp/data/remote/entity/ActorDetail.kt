package com.example.movieapp.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ActorDetail(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("image")
    val image: String
): Serializable