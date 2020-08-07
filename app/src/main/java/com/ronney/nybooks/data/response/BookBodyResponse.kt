package com.ronney.nybooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // plugin kapt
data class BookBodyResponse (
    @Json(name = "results") // vem da documentação da API
    val bookResults: List<BookResultsResponse>
)