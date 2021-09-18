package com.example.movieapp.presenter.favorite


import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.repository.MovieRepository

class FavoritePresenter(
    private val view: FavoriteContract.View,
    private val repository: MovieRepository
) : FavoriteContract.Presenter {
    override fun getFavoriteMovie(userid: Int) {
        val list: List<Movie> = repository.getFavorite(userid)
        updateUI(list)
    }

    override fun updateUI(dataList: List<Movie>) {
        view.updateViewData(dataList)
    }

}