package com.maruiz.composeworkshop.presentation.presentationmodel

data class BookPresentationModel(
    val title: String = "",
    val author: String = "",
    val date: String = "",
    val shortSynopsis: String = "",
    val synopsis: String = "",
    val image: String = "",
    val score: Float = 0f,
    val genres: List<String> = emptyList()
)