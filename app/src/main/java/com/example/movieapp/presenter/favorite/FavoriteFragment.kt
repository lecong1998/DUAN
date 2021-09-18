package com.example.movieapp.presenter.favorite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapter.FavoriteAdapter
import com.example.movieapp.adapter.OnClickItem
import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presenter.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_favorite.view.*

class FavoriteFragment : Fragment(), OnClickItem, FavoriteContract.View {
    private lateinit var presenter: FavoriteContract.Presenter
    private lateinit var adapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavoriteAdapter(this)
        presenter = FavoritePresenter(this, MovieRepository(requireContext()))
        view.recyclerview_favorite.layoutManager = LinearLayoutManager(activity)
        view.recyclerview_favorite.adapter = adapter
        val sharedPreferences =
            requireActivity().getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        val idUser: Int = sharedPreferences.getInt("ID", -1)
        presenter.getFavoriteMovie(idUser)
    }

    override fun oclick(movie: Movie) {
        var intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("movieid", movie.movieid)
        startActivity(intent)
    }

    override fun updateViewData(dataList: List<Movie>) {
        adapter.setData(dataList)
        adapter.notifyDataSetChanged()
    }
}