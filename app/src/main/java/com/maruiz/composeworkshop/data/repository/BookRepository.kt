package com.maruiz.composeworkshop.data.repository

import arrow.core.Either
import arrow.core.Right
import com.maruiz.composeworkshop.data.error.Failure
import com.maruiz.composeworkshop.data.model.BookDataModel

class BookRepository {
    fun getBooks(): Either<Failure, List<BookDataModel>> =
        Right(listOf(BookDataModel()))
}