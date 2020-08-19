package com.ronney.nybooks.presentation.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ronney.nybooks.R
import com.ronney.nybooks.data.ApiService
import com.ronney.nybooks.data.model.Movie
import com.ronney.nybooks.data.response.MovieBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getMovies() {
        ApiService.serviceMovie.getMovies().enqueue(object : Callback<MovieBodyResponse> {

            override fun onResponse(
                call: Call<MovieBodyResponse>,
                response: Response<MovieBodyResponse>
            ) {
                when {
                    response.isSuccessful -> {
                        val movies: MutableList<Movie> = mutableListOf()
                        response.body()?.let { movieBodyResponse ->
                            for (result in movieBodyResponse.movieResults) {
                                val movie = result.getMovieModel()
                                movies.add(movie)
                            }
                        }

                        moviesLiveData.value = movies
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_MOVIES, null)
                    }
                    response.code() == 401 -> {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_401)
                    }
                    response.code() == 404 -> {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_404)
                    }
                    else -> {
                        // println(response.code())
                        viewFlipperLiveData.value =
                            Pair(VIEW_FLIPPER_ERROR, R.string.error_400_generic)
                    }
                }
            }

            override fun onFailure(call: Call<MovieBodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_500_generic)
            }
        })
    }

    companion object {
        private const val VIEW_FLIPPER_MOVIES = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }

}