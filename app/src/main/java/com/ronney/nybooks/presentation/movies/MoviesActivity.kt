package com.ronney.nybooks.presentation.movies

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ronney.nybooks.R
import com.ronney.nybooks.presentation.base.BaseActivity
import com.ronney.nybooks.presentation.details.MovieDetailsActivity

class MoviesActivity: BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        setupToolBar(toolbarMain, R.string.movies_title)

        val viewModel: MoviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, Observer {
            it?.let { movies ->
                with(recyclerMovies) {
                    layoutManager =
                        LinearLayoutManager(this@MoviesActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = MoviesAdapter(movies) { movie ->
                        val intent = MovieDetailsActivity.getStartIntrent(
                            this@MoviesActivity,
                            movie.displayTitle,
                            movie.summaryShort
                        )
                        this@MoviesActivity.startActivity(intent)
                    }
                }
            }
        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                viewFlipperMovies.displayedChild = viewFlipper.first

                viewFlipper.second?.let { errorMessageResId ->
                    textViewError.text = getString(errorMessageResId)
                }
            }
        })

        viewModel.getMovies()
    }
}