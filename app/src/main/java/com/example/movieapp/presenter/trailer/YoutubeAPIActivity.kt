package com.example.movieapp.presenter.trailer

import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.R
import com.example.movieapp.data.repository.MovieRepository
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_youtube_api.*

class YoutubeAPIActivity : YouTubeBaseActivity(), YoutubeAPIContract.View, YouTubePlayer.OnInitializedListener {
    private var MOVIE_ID: String = ""
    private var VIDEO_ID: String = ""
    private lateinit var presenter: YoutubeAPIContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_api)
        presenter = YoutubeAPIPresenter(this, MovieRepository(this))
        MOVIE_ID = intent.getStringExtra("movieid")!!
        presenter.getVideoTrailer(MOVIE_ID)
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if (!p2){
            p1?.setShowFullscreenButton(true)
            p1?.cueVideo(VIDEO_ID)
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        val REQUEST_CODE = 0

        if (p1?.isUserRecoverableError == true) {
            p1.getErrorDialog(this, REQUEST_CODE).show()
        } else {
            val errorMessage =
                "There was an error initializing the YoutubePlayer ($p1)"
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    override fun updateViewData(videoId: String) {
        VIDEO_ID = videoId
        youtube_activity_view!!.initialize(getString(R.string.youtube_key), this@YoutubeAPIActivity)
    }
}