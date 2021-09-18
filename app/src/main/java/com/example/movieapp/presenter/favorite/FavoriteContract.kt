package com.example.movieapp.presenter.favorite

import com.example.movieapp.data.model.Movie

interface FavoriteContract {
    interface View{
        fun updateViewData(dataList: List<Movie>)
    }

    interface Presenter{
        fun getFavoriteMovie(userid:Int)
        fun updateUI(dataList: List<Movie>)
    }
}