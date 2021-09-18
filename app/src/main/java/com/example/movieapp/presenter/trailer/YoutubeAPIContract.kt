package com.example.movieapp.presenter.trailer

interface YoutubeAPIContract {
    interface View{
        fun updateViewData(videoId: String)
    }

    interface Presenter{
        fun getVideoTrailer(movieId:String)
        fun updateVideoTrailer(videoId: String)
    }
}