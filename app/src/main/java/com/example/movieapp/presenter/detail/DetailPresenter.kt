package com.example.movieapp.presenter.detail

import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.entity.DetailMovie
import com.example.movieapp.data.repository.MovieRepository

class DetailPresenter(
    private val view: DetailContract.View,
    private val repository: MovieRepository
) : DetailContract.Presenter {
    override fun getDetailMovie(movieId: String) {
        repository.callDetailMovie(this, movieId)
    }

    override fun updateUI(de: DetailMovie, m: Movie) {
        repository.checkMovie(m)
        val mt = repository.getMovie(m.movieid, m.userid)
        repository.callActorDetail(de.actorList){
            view.updateViewData(de, it, mt)
        }
    }

    override fun updateFavorite(check: Boolean) {
        view.updateViewFavorite(check)
    }

    override fun favorite(movieId: String, userId: Int) {
        var check = false
        val mt = repository.getMovie(movieId, userId)
        if (mt.favorite == 0) {
            mt.favorite = 1
            check = true
        } else mt.favorite = 0
        repository.update(mt)
        updateFavorite(check)
    }

    override fun watched(movieId: String, userId: Int) {
        val mt = repository.getMovie(movieId, userId)
        if (mt.watched == 0) {
            mt.watched = 1
            repository.update(mt)
        }
        view.watchMovie(movieId)
    }

    override fun rating(movieId: String, userId: Int, rate: Float) {
        val mt = repository.getMovie(movieId, userId)
        mt.rate = rate
        repository.update(mt)
    }
}