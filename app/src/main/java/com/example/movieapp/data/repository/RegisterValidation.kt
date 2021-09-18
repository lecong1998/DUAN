package com.example.movieapp.data.repository

object RegisterValidation {
    fun validation(username: String, usernameCheck : String? , password: String, confPassword: String): String{
        return if(username == "" || password == "" )
            "empty"
        else if (password != confPassword)
            "mismatch"
        else if (username == usernameCheck)
            "duplicate"
        else
            "ok"
    }
}