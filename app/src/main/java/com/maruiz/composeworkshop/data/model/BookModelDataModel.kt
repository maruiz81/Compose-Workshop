package com.maruiz.composeworkshop.data.model

import com.squareup.moshi.Json

data class BookModelDataModel(
    val bookId: Int = 0, val title: String = "", val author: String = "",
    @Json(name = "short_synopsis") val shortSynopsis: String = "", val synopsis: String = "",
    val image: String = "", @Json(name = "first_published") val firstPublished: String = "",
    val score: Float, val genres: List<String> = emptyList()
)