package com.ronney.nybooks.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService { // Singleton

    private const val urlBooks = "https://api.nytimes.com/svc/books/v3/"
    private const val urlMovies = "https://api.nytimes.com/svc/movies/v2/"

    private fun initRetrofit(pURL: String): Retrofit {

        return Retrofit.Builder()
            .baseUrl(pURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val serviceBook: NYTServices = initRetrofit(urlBooks).create(NYTServices::class.java)
    val serviceMovie: NYTServices = initRetrofit(urlMovies).create(NYTServices::class.java)
}
