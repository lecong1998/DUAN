package com.example.movieapp.presenter.profile

import com.example.movieapp.data.model.User
import com.example.movieapp.data.repository.UserRepository


class ProfilePresenter(
    private val view: ProfileContract.View,
    private val repository: UserRepository
): ProfileContract.Presenter {
    override fun getUser() {
        val idUser = repository.readUser()
        view.updateViewData(repository.getUser(idUser))
    }

    override fun updateUser(user: User) {
        repository.updateUser(user)
    }

    override fun logout() {
        repository.delete()
    }

}