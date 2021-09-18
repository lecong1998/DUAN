package com.example.movieapp.presenter.trailer

import com.example.movieapp.data.repository.MovieRepository

class YoutubeAPIPresenter(
    private val view: YoutubeAPIContract.View,
    private val repository: MovieRepository
): YoutubeAPIContract.Presenter {
    override fun getVideoTrailer(movieId: String) {
        repository.callVideoTrailer(this, movieId)
    }

    override fun updateVideoTrailer(videoId: String) {
        view.updateViewData(videoId)
    }
}