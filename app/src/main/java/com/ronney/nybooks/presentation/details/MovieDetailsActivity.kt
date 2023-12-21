package com.ronney.nybooks.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.ronney.nybooks.R
import com.ronney.nybooks.presentation.base.BaseActivity

class MovieDetailsActivity: BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        setupToolBar(toolbarMain, R.string.movie_details_title, true)

        movieDetailsTitle.text = intent.getStringExtra(MovieDetailsActivity.EXTRA_TITLE)
        movieDetailsSummary.text = intent.getStringExtra(MovieDetailsActivity.EXTRA_DESCRIPTION)
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntrent(context: Context, title: String, description: String): Intent {
            return Intent(context, MovieDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}