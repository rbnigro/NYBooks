package com.ronney.nybooks.presentation.databind

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.ronney.nybooks.R
import com.ronney.nybooks.data.viewmodel.DataBindViewModel
import com.ronney.nybooks.databinding.ActivityDatabindBinding
import com.ronney.nybooks.presentation.base.BaseActivity

class DataBindActivity: BaseActivity() {

    private val viewModel: DataBindViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kotlin gerou o Objeto à partir do nome do XML (UAU!!!)
        val binding: ActivityDatabindBinding = DataBindingUtil.setContentView(this, R.layout.activity_databind)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}