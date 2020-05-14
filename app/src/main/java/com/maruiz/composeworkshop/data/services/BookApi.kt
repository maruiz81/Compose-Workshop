package com.maruiz.composeworkshop.data.services

import com.maruiz.composeworkshop.data.model.BookModelDataModel
import retrofit2.Call
import retrofit2.http.GET

interface BookApi {
    @GET("BookList.json")
    fun getBooks(): Call<List<BookModelDataModel>>
}