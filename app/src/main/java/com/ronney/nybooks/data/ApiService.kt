package com.ronney.nybooks.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private fun initRetrofit(): Retrofit {

        val urlB = "https://api.nytimes.com/svc/books/v3/"
        val urlM = "https://api.nytimes.com/svc/movies/v2/"

        return Retrofit.Builder()
            .baseUrl(urlM)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service: NYTServices = initRetrofit().create(NYTServices::class.java)
}
