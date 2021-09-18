package com.example.movieapp.presenter.search

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapter.NoSearchAdapter
import com.example.movieapp.adapter.OnClickItemNoSearch
import com.example.movieapp.adapter.OnClickItemSearch
import com.example.movieapp.adapter.SearchAdapter
import com.example.movieapp.data.remote.entity.FilmSearch
import com.example.movieapp.data.remote.entity.TopMovie
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presenter.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlin.collections.ArrayList

class SearchFragment : Fragment(), OnClickItemSearch, SearchContract.View, OnClickItemNoSearch {
    private lateinit var presenter: SearchContract.Presenter
    private lateinit var adapter: SearchAdapter
    private lateinit var noadapter: NoSearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SearchAdapter(this)
        noadapter = NoSearchAdapter(this)
        presenter = SearchPresenter(this, MovieRepository(requireContext()))

        recyclerview_search.layoutManager = LinearLayoutManager(activity)

        search_view?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query?.isNotEmpty() == true) {
                    presenter.getSearchMovie(query)
                } else {
                    presenter.getNoSearchMovie()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.isNotEmpty() == true) {
                    presenter.getSearchMovie(newText)
                } else {
                    presenter.getNoSearchMovie()
                }
                return false
            }
        })
    }

    override fun OnClickItem(film: FilmSearch) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("movieid", film.id)
        startActivity(intent)
    }

    override fun OnClickItem(film: TopMovie) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("movieid", film.id)
        startActivity(intent)
    }

    override fun updateViewDataSearch(dataList: List<FilmSearch>) {
        recyclerview_search.adapter = adapter
        adapter.setData(dataList)
        recyclerview_search.adapter?.notifyDataSetChanged()
    }

    override fun updateViewDataNoSearch(dataList: List<TopMovie>) {
        val list = ArrayList<TopMovie>()
        for (i in 0..9)
            list.add(dataList[i])
        recyclerview_search.adapter = noadapter
        noadapter.setData(list)
        recyclerview_search.adapter?.notifyDataSetChanged()
    }
}