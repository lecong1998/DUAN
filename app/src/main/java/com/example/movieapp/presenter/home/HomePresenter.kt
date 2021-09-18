package com.example.movieapp.presenter.home

import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.entity.TopMovie
import com.example.movieapp.data.repository.MovieRepository

class HomePresenter(
    private val view: HomeContract.View,
    private val repository: MovieRepository
): HomeContract.Presenter {
    override fun getMostPopularMovie() {
        repository.callMostPopularMovie(this)
    }

    override fun getNewFilm() {
        repository.callNewFilm(this)
    }

    override fun getWatchMovie(userid: Int) {
        val list: List<Movie> = repository.getWatch(userid)
        updateWatchUI(list)
    }

    override fun updateWatchUI(dataList: List<Movie>) {
        view.updateViewDataWatch(dataList)
    }

    override fun updateMostPopularMovie(dataList: List<TopMovie>) {
        view.updateViewDataMostPopularMovie(dataList)
    }

    override fun updateNewMovie(dataList: List<TopMovie>) {
        view.updateViewDataNewFilm(dataList)
    }
}