package com.maruiz.composeworkshop.data.model


data class BookDataModel(
    val bookId: Int = 0,
    val title: String = "",
    val author: String = "",
    val shortSynopsis: String = "",
    val image: String = "",
    val firstPublished: String = "",
    val score: Float = 0f
)