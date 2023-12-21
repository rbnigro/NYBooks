package com.ronney.nybooks.presentation.menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ronney.nybooks.R
import com.ronney.nybooks.presentation.base.BaseActivity
import com.ronney.nybooks.presentation.books.BooksActivity
import com.ronney.nybooks.presentation.databind.DataBindActivity
import com.ronney.nybooks.presentation.movies.MoviesActivity

class Menu : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        action_books.setOnClickListener {
            val intent = Intent(this, BooksActivity::class.java)
            startActivity(intent)
        }

        action_movies.setOnClickListener{
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }

        action_databind.setOnClickListener{
            val intent = Intent(this, DataBindActivity::class.java)
            startActivity(intent)
        }
    }
}