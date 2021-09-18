package com.example.movieapp.presenter.login

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.data.model.User
import com.example.movieapp.data.repository.LoginValidation
import com.example.movieapp.data.repository.UserRepository

class LoginPresenter(
    private val view : LoginContract.View,
    private val repository : UserRepository,


): LoginContract.Presenter {
    override fun checkLogin(username: String, password: String) {
        val userCheck: User = repository.checkLogin(username, password)

        when (LoginValidation.validation(userCheck,username,password)) {
            "empty" -> view.showMessage("Username or password is empty")
            "incorrect" -> view.showMessage("Incorrect username/password or user does not exist")
            "ok" -> {
                repository.saveUser(userCheck.id)
                view.showMessage("Login success")
            }
            "failed" -> view.showMessage("Login failed")
        }
    }


}