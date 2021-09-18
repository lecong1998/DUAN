package com.example.movieapp.data.remote.api

import com.example.movieapp.data.remote.entity.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("MostPopularMovies/{api_key}")
    fun getMostPopularMovies(@Path("api_key") api_key: String): Call<TopMoviesResponse>

    @GET("ComingSoon/{api_key}")
    fun getNewFilm(@Path("api_key") api_key: String): Call<TopMoviesResponse>

    @GET("Top250Movies/{api_key}")
    fun getNoSearchMovie(@Path("api_key") api_key: String): Call<TopMoviesResponse>

    @GET("Title/{api_key}/{movieId}")
    fun getDetailMovie(@Path("api_key") api_key: String, @Path("movieId") movieId: String): Call<DetailMovie>

    @GET("YouTubeTrailer/{api_key}/{movieId}")
    fun getVideoTrailer(@Path("api_key") api_key: String, @Path("movieId") movieId: String): Call<VideoTrailer>

    @GET("Name/{api_key}/{actorId}")
    fun getActorDetail(@Path("api_key") api_key: String, @Path("actorId")actor_id: String): Call<ActorDetail>

    @GET("SearchMovie/{api_key}/{search_string}")
    fun getSearchMovie(@Path("api_key") api_key: String, @Path("search_string") search_string: String): Call<FilmSearchResponse>
}