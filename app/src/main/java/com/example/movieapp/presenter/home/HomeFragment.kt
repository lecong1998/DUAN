package com.example.movieapp.presenter.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.OnClickTopMovie
import com.example.movieapp.adapter.OnClickWatch
import com.example.movieapp.adapter.TopMovieAdapter
import com.example.movieapp.adapter.WatchAdapter
import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.entity.FilmSearch
import com.example.movieapp.data.remote.entity.TopMovie
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presenter.detail.DetailActivity
import com.example.movieapp.presenter.search.SearchContract
import com.example.movieapp.presenter.search.SearchPresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View, OnClickTopMovie, OnClickWatch ,SearchContract.View{
    private lateinit var presenter: HomeContract.Presenter
    private lateinit var presenter_topmovie: SearchContract.Presenter
    private lateinit var adapter_newfilm: TopMovieAdapter
    private lateinit var adapter_popular: TopMovieAdapter
    private lateinit var adapter_watch: WatchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences =
            requireActivity().getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        val idUser: Int = sharedPreferences.getInt("ID", -1)

        presenter = HomePresenter(this, MovieRepository(requireContext()))
        adapter_popular = TopMovieAdapter(this)
        rcv_popular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcv_popular.adapter = adapter_popular
        presenter.getMostPopularMovie()

        adapter_newfilm = TopMovieAdapter(this)
        rcv_new.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcv_new.adapter = adapter_newfilm
        presenter.getNewFilm()

        adapter_watch = WatchAdapter(this)
        rcv_watched.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcv_watched.adapter = adapter_watch
        presenter.getWatchMovie(idUser)

        presenter_topmovie = SearchPresenter(this, MovieRepository(requireContext()))
        presenter_topmovie.getNoSearchMovie()

    }


    override fun updateViewDataMostPopularMovie(dataList: List<TopMovie>) {
        val popularfilm  = ArrayList<TopMovie>()
        for (i in 0 .. 9)
        {
            popularfilm.add(dataList[i])
        }
        adapter_popular.setData(popularfilm)
        rcv_popular.adapter?.notifyDataSetChanged()
    }

    override fun updateViewDataNewFilm(dataList: List<TopMovie>) {
        val listnewfilm  = ArrayList<TopMovie>()
        for (i in 0 .. 9)
        {
            listnewfilm.add(dataList[i])
        }
        adapter_newfilm.setData(listnewfilm)
        rcv_new.adapter?.notifyDataSetChanged()

    }

    override fun updateViewDataWatch(dataList: List<Movie>) {
        adapter_watch.setData(dataList)
        rcv_watched.adapter?.notifyDataSetChanged()
    }

    override fun clickOnItem(m: TopMovie) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("movieid", m.id)
        startActivity(intent)
    }

    override fun clickOnItem(m: Movie) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("movieid", m.movieid)
        startActivity(intent)
    }

    override fun updateViewDataSearch(dataList: List<FilmSearch>) {
        TODO("Not yet implemented")
    }

    override fun updateViewDataNoSearch(dataList: List<TopMovie>) {

        val slidefilm  = ArrayList<TopMovie>()
        for (i in 0 .. 5)
        {
            slidefilm.add(dataList[i])
        }

        for (item in slidefilm)
        {
            val imageView : ImageView = ImageView(requireContext())
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(requireContext()).load(item.image).into(imageView)
            imageView.setOnClickListener{
                clickOnItem(item)
            }
            flipper_view?.addView(imageView)
        }
        flipper_view.flipInterval = 2000
        flipper_view.startFlipping()
    }
}