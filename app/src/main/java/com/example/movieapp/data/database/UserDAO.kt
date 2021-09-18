package com.example.movieapp.data.database

import androidx.room.*
import com.example.movieapp.data.model.User


@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun newUser(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM User WHERE id = :idUser")
    fun getUser(idUser: Int): User

    @Query("SELECT * FROM User WHERE username = :name AND password = :password ")
    fun checkLogin(name: String, password: String): User

    @Query("SELECT username FROM User WHERE username = :name")
    fun checkRegister(name: String): String
}