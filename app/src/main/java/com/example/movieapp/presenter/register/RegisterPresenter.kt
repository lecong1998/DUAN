package com.example.movieapp.presenter.register

import com.example.movieapp.data.model.User
import com.example.movieapp.data.repository.RegisterValidation
import com.example.movieapp.data.repository.UserRepository


class RegisterPresenter(
    private val view : RegisterContract.View,
    private val repository: UserRepository
) : RegisterContract.Presenter{
    override fun newUser(username: String, password: String, confPassword: String,fullname: String, email:String): Boolean {
        val check = repository.checkRegister(username)

        when (RegisterValidation.validation(username,check,password,confPassword)) {
            "empty" -> {
                view.showMessage("Username or password is empty")
                return false
            }
            "duplicate" -> {
                view.showMessage("User already exist")
                return false
            }
            "mismatch" -> {
                view.showMessage("Password and confirm password does not match")
                return false
            }
            "ok" -> {
                val user = User(username, password, fullname,email)
                repository.newUser(user)
                view.showMessage(user.fullname.toString()+" "+user.email.toString()+" Registed successfully")
                return true
            }
            else -> {
                view.showMessage("Registration failed")
                return false
            }
        }

    }
}