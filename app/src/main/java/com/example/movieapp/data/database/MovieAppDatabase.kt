package com.example.movieapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.model.User


@Database(entities = [User::class, Movie::class], version = 1)
abstract class MovieAppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun getMovieDAO(): MovieDAO
    companion object {
        @Volatile
        private var INSTANCE: MovieAppDatabase? = null

        fun getDataBase(context: Context): MovieAppDatabase {
            val instance = INSTANCE
            if (instance != null)
                return instance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieAppDatabase::class.java,
                    "movieapp_database"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}