package com.example.movieapp.presenter.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.ActorDetailAdapter
import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.entity.ActorDetail
import com.example.movieapp.data.remote.entity.DetailMovie
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presenter.trailer.YoutubeAPIActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailContract.View {
    private lateinit var presenter: DetailContract.Presenter
    private var movieId: String = ""
    private var idUser: Int = -1
    private lateinit var adapter: ActorDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getInit()
        getData()
        getAction()
    }

    private fun getAction() {
        detail_activity_btn_add_favorite.setOnClickListener{
            presenter.favorite(movieId, idUser)
        }
        detail_activity_btn_watch.setOnClickListener{
            presenter.watched(movieId, idUser)
        }

        detail_activity_rating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            presenter.rating(movieId, idUser, rating)
        }
    }

    private fun getInit() {
        presenter = DetailPresenter(this, MovieRepository(this))
        adapter = ActorDetailAdapter()
        detail_activity_rc_actor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        detail_activity_rc_actor.adapter = adapter
        val sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        idUser = sharedPreferences.getInt("ID",-1)
    }

    private fun getData() {
        movieId = intent.getStringExtra("movieid")!!
        presenter.getDetailMovie(movieId)
    }

    override fun updateViewData(de: DetailMovie, list:ArrayList<ActorDetail>, m: Movie) {
        Glide.with(this@DetailActivity).load(de.image).into(detail_activity_image_film)
        detail_activity_tv_detail_film.text = de.title
        detail_activity_tv_content.text = de.plot

        detail_activity_tv_director.text = de.directors
        detail_activity_tv_genre.text = de.genres
        detail_activity_tv_date.text = de.releaseDate
        detail_activity_tv_country.text = de.countries

        adapter.setData(list)
        detail_activity_rc_actor.adapter?.notifyDataSetChanged()

        var check = false
        if (m.favorite == 1) {
            check = true
        }
        updateViewFavorite(check)
        updateViewRating(m.rate)
    }

    override fun updateViewFavorite(check: Boolean) {
        if(check){
            detail_activity_btn_add_favorite.setImageResource(R.drawable.ic_favorite)
        } else {
            detail_activity_btn_add_favorite.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    override fun watchMovie(movieId: String) {
        intent = Intent(this, YoutubeAPIActivity::class.java)
        intent.putExtra("movieid", movieId)
        startActivity(intent)
    }

    override fun updateViewRating(rate: Float) {
        detail_activity_rating.rating = rate
    }
}