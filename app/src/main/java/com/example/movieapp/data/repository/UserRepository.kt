package com.example.movieapp.data.repository

import android.content.Context
import android.net.Uri
import com.example.movieapp.data.database.UserDAO
import com.example.movieapp.data.database.MovieAppDatabase
import com.example.movieapp.data.model.User


class UserRepository(val context: Context) {
    private val userDAO: UserDAO = MovieAppDatabase.getDataBase(context).userDAO()

    fun newUser(user: User) {
        userDAO.newUser(user)
    }

    fun updateUser(user: User){
        userDAO.update(user)
    }

    fun getUser(idUser: Int): User{
        return userDAO.getUser(idUser)
    }

    fun checkLogin(name: String, password: String): User {
        return userDAO.checkLogin(name, password)
    }

    fun checkRegister(name: String): String {
        return userDAO.checkRegister(name)
    }

    fun saveUser(idUser: Int){
        val sharedPreferences = context.getSharedPreferences("LoginData",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("ID",idUser)
        editor.commit()
    }

    fun  readUser():Int{
        val sharedPreferences = context.getSharedPreferences("LoginData",Context.MODE_PRIVATE)
        val idUser: Int = sharedPreferences.getInt("ID",-1)
        return idUser
    }

    fun delete(){
        val sharedPreferences = context.getSharedPreferences("LoginData",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
    }
}