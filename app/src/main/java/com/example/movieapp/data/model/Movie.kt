package com.example.movieapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie")
data class Movie(
    @ColumnInfo(name = "movieid")
    var movieid: String,
    @ColumnInfo(name = "userid")
    var userid: Int,
    @ColumnInfo(name = "movie_name")
    var name: String = "",
    @ColumnInfo(name = "movie_img")
    var img: String = "",
    @ColumnInfo(name = "movie_genre")
    var genre: String = "",
) : Serializable {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "favorite")
    var favorite: Int = 0

    @ColumnInfo(name = "watched")
    var watched: Int = 0

    @ColumnInfo(name = "rate")
    var rate: Float = 0f
}
