package com.example.movieapp.presenter.search

import com.example.movieapp.data.remote.entity.FilmSearch
import com.example.movieapp.data.remote.entity.TopMovie
import com.example.movieapp.data.repository.MovieRepository

class SearchPresenter(
    private val view: SearchContract.View,
    private val repository: MovieRepository
) : SearchContract.Presenter {
    override fun getSearchMovie(search: String) {
        repository.callFilmSearch(this, search)
    }

    override fun updateSearchUI(dataList: List<FilmSearch>) {
        view.updateViewDataSearch(dataList)
    }

    override fun getNoSearchMovie() {
        repository.callNoFilmSearch(this)
    }

    override fun updateNoSearchUI(dataList: List<TopMovie>) {
        view.updateViewDataNoSearch(dataList)
    }
}