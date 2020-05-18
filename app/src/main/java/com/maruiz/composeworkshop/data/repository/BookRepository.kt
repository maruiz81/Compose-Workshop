package com.maruiz.composeworkshop.data.repository

import arrow.core.Either
import com.maruiz.composeworkshop.data.error.Failure
import com.maruiz.composeworkshop.data.extensions.makeCall
import com.maruiz.composeworkshop.data.model.BookDataModel
import com.maruiz.composeworkshop.data.services.BookApi

interface BookRepository {
    suspend fun getBooks(): Either<Failure, List<BookDataModel>>

    class Network(private val bookService: BookApi) : BookRepository {
        override suspend fun getBooks(): Either<Failure, List<BookDataModel>> =
            bookService.getBooks().makeCall(emptyList())
    }
}