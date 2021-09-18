package com.example.movieapp.presenter.home

import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.entity.TopMovie

interface HomeContract {
    interface View{
        fun updateViewDataMostPopularMovie(dataList: List<TopMovie>)
        fun updateViewDataNewFilm(dataList: List<TopMovie>)
        fun updateViewDataWatch(dataList: List<Movie>)
    }

    interface Presenter{
        fun getMostPopularMovie()
        fun getNewFilm()
        fun getWatchMovie(userid:Int)

        fun updateWatchUI(dataList: List<Movie>)
        fun updateMostPopularMovie(dataList: List<TopMovie>)
        fun updateNewMovie(dataList: List<TopMovie>)
    }
}