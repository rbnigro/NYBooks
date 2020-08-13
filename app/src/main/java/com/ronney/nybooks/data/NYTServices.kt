package com.ronney.nybooks.data

import com.ronney.nybooks.data.response.BookBodyResponse
import com.ronney.nybooks.data.response.MovieBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "W0nC0pK2gmhm7kth5DwbkKmg6HsmEwDy",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>

    @GET("reviews/search.json") // ver na API
    fun getMovies(
        @Query("api-key") apiKey: String = "W0nC0pK2gmhm7kth5DwbkKmg6HsmEwDy"
    ): Call<MovieBodyResponse>
}