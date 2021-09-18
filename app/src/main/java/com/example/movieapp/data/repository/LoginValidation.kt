package com.example.movieapp.data.repository

import com.example.movieapp.data.model.User


object LoginValidation {
    fun validation(userCheck : User?, username:String, password : String) : String{
        return if (username.isEmpty() || password.isEmpty())
            "empty"
        else if (userCheck == null)
            "incorrect"
        else if (userCheck.username == username && userCheck.password == password){
            "ok"
        }
        else
            "failed"
    }
}