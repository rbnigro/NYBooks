package com.ronney.nybooks.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.ronney.nybooks.R
import com.ronney.nybooks.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BookDetailsActivity: BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        setupToolBar(toolbarMain, R.string.book_details_title, true)

        bookDetailsTitle.text = intent.getStringExtra(EXTRA_TITLE)
        bookDetailsDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntrent(context: Context, title: String, description: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}