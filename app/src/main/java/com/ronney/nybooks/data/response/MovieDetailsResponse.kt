package com.ronney.nybooks.data.response

import com.ronney.nybooks.data.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailsResponse(
    @Json(name = "display_title")
    val displayTitle: String,
    @Json(name = "mpaa_rating")
    val mpaaRating: String,
    @Json(name = "summary_short")
    val summaryShort: String
) {
    fun getMovieModel() = Movie(
        displayTitle = this.displayTitle,
        mpaaRating = this.mpaaRating,
        summaryShort = this.summaryShort
    )
}
