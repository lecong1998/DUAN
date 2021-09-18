package com.example.movieapp.presenter.search

import com.example.movieapp.data.remote.entity.FilmSearch
import com.example.movieapp.data.remote.entity.TopMovie

interface SearchContract {
    interface View{
        fun updateViewDataSearch(dataList: List<FilmSearch>)
        fun updateViewDataNoSearch(dataList: List<TopMovie>)
    }

    interface Presenter{
        fun getSearchMovie(search: String)
        fun updateSearchUI(dataList: List<FilmSearch>)

        fun getNoSearchMovie()
        fun updateNoSearchUI(dataList: List<TopMovie>)
    }
}