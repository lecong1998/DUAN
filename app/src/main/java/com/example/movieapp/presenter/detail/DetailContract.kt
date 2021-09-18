package com.example.movieapp.presenter.detail

import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.entity.ActorDetail
import com.example.movieapp.data.remote.entity.DetailMovie

interface DetailContract {
    interface View{
        fun updateViewData(de: DetailMovie,list: ArrayList<ActorDetail>, m: Movie)
        fun updateViewFavorite(check: Boolean)
        fun watchMovie(movieId: String)
        fun updateViewRating(rate: Float)
    }

    interface Presenter{
        fun getDetailMovie(movieId: String)
        fun updateUI(de: DetailMovie, m: Movie)
        fun updateFavorite(check: Boolean)
        fun favorite(movieId: String, userId: Int)
        fun watched(movieId: String, userId: Int)
        fun rating(movieId: String, userId: Int, rate: Float)
    }
}