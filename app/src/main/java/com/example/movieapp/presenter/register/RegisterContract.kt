package com.example.movieapp.presenter.register

interface RegisterContract {
    interface View{
        fun showMessage(message : String)
    }
    interface Presenter{
        fun newUser(username :String,password:String,confPassword : String, fullname: String, email:String) : Boolean
    }

}