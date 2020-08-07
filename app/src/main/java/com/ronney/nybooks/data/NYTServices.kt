package com.ronney.nybooks.data

import com.ronney.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "Ler8iCbg2D7CwAeqYD2BaLQZdp0NqnGs",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}