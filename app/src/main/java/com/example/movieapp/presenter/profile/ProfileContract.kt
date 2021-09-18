package com.example.movieapp.presenter.profile

import com.example.movieapp.data.model.User

interface ProfileContract {
    interface View{
        fun updateViewData(user: User)
    }
    interface Presenter{
        fun getUser()
        fun updateUser(user:User)
        fun logout()
    }
}