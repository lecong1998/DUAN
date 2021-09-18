package com.example.movieapp.data.repository

import android.content.Context
import android.util.Log
import com.example.movieapp.R
import com.example.movieapp.data.database.MovieAppDatabase
import com.example.movieapp.data.database.MovieDAO
import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.api.ApiClient
import com.example.movieapp.data.remote.entity.*
import com.example.movieapp.presenter.detail.DetailContract
import com.example.movieapp.presenter.home.HomeContract
import com.example.movieapp.presenter.search.SearchContract
import com.example.movieapp.presenter.trailer.YoutubeAPIContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(val context: Context) {
    private val movieDAO: MovieDAO =
        MovieAppDatabase.getDataBase(context).getMovieDAO()
    val sharedPreferences = context.getSharedPreferences("LoginData", Context.MODE_PRIVATE)
    val idUser: Int = sharedPreferences.getInt("ID",-1)

    fun checkMovie(m: Movie) {
        val mt = movieDAO.getMovie(m.movieid, m.userid)
        if (mt == null) {
            movieDAO.addMovie(m)
        }
    }

    fun getMovie(movieId: String, userId: Int): Movie {
        return movieDAO.getMovie(movieId, userId)!!
    }

    fun getFavorite(userId: Int) : List<Movie>{
        return movieDAO.getFavorite(userId)!!
    }

    fun getWatch(userId: Int) : List<Movie>{
        return movieDAO.getWatched(userId)!!
    }

    fun addMovie(m: Movie) {
        movieDAO.addMovie(m)
    }

    fun update(m: Movie) {
        movieDAO.updateMovie(m)
    }

    fun callMostPopularMovie(presenter: HomeContract.Presenter) {
        var dataList: List<TopMovie> = ArrayList<TopMovie>()

        val call: Call<TopMoviesResponse> =
            ApiClient.getClient.getMostPopularMovies(context.getString(R.string.api_key))
        call.enqueue(object : Callback<TopMoviesResponse> {
            override fun onResponse(
                call: Call<TopMoviesResponse>?,
                response: Response<TopMoviesResponse>?
            ) {
                if (response?.isSuccessful!!) {
                    dataList = (response?.body()?.topMovies!!)
                    presenter.updateMostPopularMovie(dataList)
                }
            }

            override fun onFailure(call: Call<TopMoviesResponse>?, t: Throwable?) {
                Log.d("Test_API", "onFailure() called with: call = $call, t = $t")
            }
        })
    }

    fun callNewFilm(presenter: HomeContract.Presenter)
    {
        var dataListNewFilm : List<TopMovie> = ArrayList<TopMovie>()
        val call : Call<TopMoviesResponse> = ApiClient.getClient.getNewFilm(context.getString(R.string.api_key))
        call.enqueue(object : Callback<TopMoviesResponse>{
            override fun onResponse(
                call: Call<TopMoviesResponse>,
                response: Response<TopMoviesResponse>
            ) {
                if (response?.isSuccessful!!) {
                    val responseBody = response.body()!!
                    dataListNewFilm = (responseBody.topMovies!!)
                    presenter.updateNewMovie(dataListNewFilm)
                }
            }

            override fun onFailure(call: Call<TopMoviesResponse>, t: Throwable) {
                Log.d("Test_API", "onFailure() called with: call = $call, t = $t")
            }

        })
    }


    fun callDetailMovie(presenter: DetailContract.Presenter, movieid: String) {
        val call: Call<DetailMovie> =
            ApiClient.getClient.getDetailMovie(context.getString(R.string.api_key), movieid)
        call.enqueue(object : Callback<DetailMovie> {
            override fun onResponse(
                call: Call<DetailMovie>?,
                response: Response<DetailMovie>?
            ) {
                val de = response!!.body()!!
                val m = Movie(
                    de.id,
                    idUser,
                    de.title,
                    de.image,
                    de.genres
                )
                presenter.updateUI(de, m)
            }

            override fun onFailure(call: Call<DetailMovie>?, t: Throwable?) {
                Log.d("Test_API", "onFailure() called with: call = $call, t = $t")
            }
        })
    }

    fun callActorDetail(list: ArrayList<Actor>, onResult: (ArrayList<ActorDetail>) -> Unit){
        val dataList = ArrayList<ActorDetail>()
        for (i in list) {
            val call: Call<ActorDetail> =
                ApiClient.getClient.getActorDetail(context.getString(R.string.api_key), i.id)
            call.enqueue(object : Callback<ActorDetail> {
                override fun onResponse(
                    call: Call<ActorDetail>,
                    response: Response<ActorDetail>
                ) {
                    if (response.isSuccessful) {
                        val mp = (response.body()) as ActorDetail
                        dataList.add(mp)
                    }

                    if(dataList.size == list.size){
                        onResult.invoke(dataList)
                    }
                }

                override fun onFailure(call: Call<ActorDetail>, t: Throwable) {
                    Log.d("Test_API", "onFailure() called with: call = $call, t = $t")
                }
            })
        }
    }

    fun callVideoTrailer(presenter: YoutubeAPIContract.Presenter, movieid: String) {
        val call: Call<VideoTrailer> =
            ApiClient.getClient.getVideoTrailer(context.getString(R.string.api_key), movieid)
        call.enqueue(object : Callback<VideoTrailer> {
            override fun onResponse(
                call: Call<VideoTrailer>?,
                response: Response<VideoTrailer>?
            ) {
                val m = response!!.body()!!
                presenter.updateVideoTrailer(m.videoId)
            }

            override fun onFailure(call: Call<VideoTrailer>?, t: Throwable?) {
                Log.d("Test_API", "onFailure() called with: call = $call, t = $t")
            }
        })
    }

    fun callFilmSearch(presenter: SearchContract.Presenter, search_string: String) {
        var dataList : List<FilmSearch> = ArrayList<FilmSearch>()
        val call : Call<FilmSearchResponse> = ApiClient.getClient.getSearchMovie(context.getString(R.string.api_key), search_string)
        call.enqueue(object : Callback<FilmSearchResponse>{
            override fun onResponse(
                call: Call<FilmSearchResponse>,
                response: Response<FilmSearchResponse>
            ) {
                if (response?.isSuccessful!!) {
                    val responseBody = response.body()!!
                    dataList = (responseBody.FilmSearchs!!)
                    presenter.updateSearchUI(dataList)
                }
            }

            override fun onFailure(call: Call<FilmSearchResponse>, t: Throwable) {
                Log.d("Test_API", "onFailure() called with: call = $call, t = $t")
            }
        })
    }

    fun callNoFilmSearch(presenter: SearchContract.Presenter)
    {
        var dataListNewFilm : List<TopMovie> = ArrayList<TopMovie>()
        val call : Call<TopMoviesResponse> = ApiClient.getClient.getNoSearchMovie(context.getString(R.string.api_key))
        call.enqueue(object : Callback<TopMoviesResponse>{
            override fun onResponse(
                call: Call<TopMoviesResponse>,
                response: Response<TopMoviesResponse>
            ) {
                if (response?.isSuccessful!!) {
                    val responseBody = response.body()!!
                    dataListNewFilm = (responseBody.topMovies!!)
                    presenter.updateNoSearchUI(dataListNewFilm)
                }
            }

            override fun onFailure(call: Call<TopMoviesResponse>, t: Throwable) {
                Log.d("Test_API", "onFailure() called with: call = $call, t = $t")
            }

        })
    }
}