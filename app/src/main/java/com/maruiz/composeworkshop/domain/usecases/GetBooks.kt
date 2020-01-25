package com.maruiz.composeworkshop.domain.usecases

import arrow.core.Either
import com.maruiz.composeworkshop.data.error.Failure
import com.maruiz.composeworkshop.data.repository.BookRepository
import com.maruiz.composeworkshop.domain.model.BookModelDomainModel

class GetBooks(private val bookRepository: BookRepository) {
    operator fun invoke(onResult: (Either<Failure, List<BookModelDomainModel>>) -> Unit) {
        onResult(bookRepository.getBooks().map { books ->
            books.map {
                BookModelDomainModel(
                    it.title,
                    it.author,
                    it.firstPublished,
                    it.shortSynopsis,
                    it.image
                )
            }
        })
    }
}
