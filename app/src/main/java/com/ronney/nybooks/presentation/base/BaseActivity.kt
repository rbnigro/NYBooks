package com.ronney.nybooks.presentation.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    protected fun setupToolBar(toolbar: Toolbar, titleIdRes: Int, showBackButton: Boolean = false) {
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbarMain)

        if (showBackButton) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}