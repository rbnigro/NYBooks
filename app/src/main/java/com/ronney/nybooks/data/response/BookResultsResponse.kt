package com.ronney.nybooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // representa cada "pai" do JSON
data class BookResultsResponse (
    @Json(name = "book_details")
    var bookDetailsResponse: List<BookDetailsResponse>
)