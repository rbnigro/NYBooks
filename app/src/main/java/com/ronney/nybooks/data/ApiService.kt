package com.ronney.nybooks.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private val urlB = "https://api.nytimes.com/svc/books/v3/"
    private val urlM = "https://api.nytimes.com/svc/movies/v2/"

    private fun initRetrofit(pURL: String): Retrofit {

        return Retrofit.Builder()
            .baseUrl(pURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val serviceBook: NYTServices = initRetrofit(urlB).create(NYTServices::class.java)
    val serviceMovie: NYTServices = initRetrofit(urlM).create(NYTServices::class.java)
}
