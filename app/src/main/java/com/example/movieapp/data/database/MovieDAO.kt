package com.example.movieapp.data.database

import androidx.room.*
import com.example.movieapp.data.model.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMovie(m: Movie)

    @Update
    fun updateMovie(m: Movie)

    @Delete
    fun deteleMovie(m: Movie)

    @Query("SELECT * FROM movie WHERE movieid=:movieid AND userid=:userid")
    fun getMovie(movieid: String, userid: Int): Movie?

    @Query("SELECT * FROM movie WHERE userid= :userid AND favorite=1")
    fun getFavorite(userid: Int): List<Movie>?

    @Query("SELECT * FROM movie WHERE userid= :userid AND watched = 1")
    fun getWatched(userid: Int): List<Movie>?
}