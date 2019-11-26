package com.example.tmdbfinalapp.features.movieSearch


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tmdbfinalapp.R
import com.example.tmdbfinalapp.RetrofitProvider
import com.example.tmdbfinalapp.pojo.TMDbClass
import kotlinx.android.synthetic.main.fragment_movie_search.*
import kotlinx.android.synthetic.main.fragment_movie_search.view.*
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class MovieSearchFragment : Fragment() {

    private lateinit var movieSearchRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_search, container, false)
        movieSearchRecyclerView = view.recyclerViewSearchResult
        view.btnSearchForMovie.setOnClickListener {
            callRetrofit(context!!, edtUserMovieName.text.toString())
        }
        return view
    }

    private fun setUpRecyclerViewAdapter(tmDbClass: TMDbClass) {
        recyclerViewSearchResult.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerViewSearchResult.adapter =
            ItemAdapter(tmDbClass) {}
    }

    private fun callRetrofit(context: Context, movieName: String) {
        RetrofitProvider.provideRetrofit()
            .findMoviesContain(movieName)
            .enqueue(object : retrofit2.Callback<TMDbClass> {
                override fun onFailure(call: Call<TMDbClass>, t: Throwable) {
                    Log.e("Result", "error : ${t.message}")

                }

                override fun onResponse(call: Call<TMDbClass>, response: Response<TMDbClass>) {
                    Log.e("Result", "resutl : ${response.body()?.totalResults}")
                    val responseResult = response.body()
                    if (responseResult != null) {
                        setUpRecyclerViewAdapter(responseResult)
                    }
                }

            })
    }
}

