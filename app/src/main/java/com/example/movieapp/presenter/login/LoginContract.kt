package com.example.movieapp.presenter.login

interface LoginContract {
    interface View{
        fun showMessage(message : String)
    }
    interface Presenter{
        fun checkLogin(username : String, password : String)
    }
}