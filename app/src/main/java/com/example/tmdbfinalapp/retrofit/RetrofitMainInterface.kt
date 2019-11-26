package com.example.tmdbfinalapp.retrofit

import com.example.tmdbfinalapp.pojo.TMDbClass
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitMainInterface {

    @GET("search/movie?api_key=7ac72bd9edccc294270b0fb0981b7fb9&language=en-US&page=1&include_adult=false")
    fun findMoviesContain(@Query("query") movieName: String): Call<TMDbClass>
}