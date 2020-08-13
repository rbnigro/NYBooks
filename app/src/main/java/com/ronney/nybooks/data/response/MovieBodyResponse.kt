package com.ronney.nybooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // plugin kapt
data class MovieBodyResponse (
    @Json(name = "results") // vem da documentação da API
    val movieResults: List<MovieDetailsResponse>
)