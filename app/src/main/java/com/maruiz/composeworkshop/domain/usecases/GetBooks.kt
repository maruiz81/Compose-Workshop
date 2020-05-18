package com.maruiz.composeworkshop.domain.usecases

import arrow.core.Either
import com.maruiz.composeworkshop.data.error.Failure
import com.maruiz.composeworkshop.data.repository.BookRepository
import com.maruiz.composeworkshop.domain.model.BookDomainModel

class GetBooks(private val bookRepository: BookRepository) :
    UseCase<List<BookDomainModel>, Unit>() {
    override suspend fun run(params: Unit): Either<Failure, List<BookDomainModel>> =
        bookRepository.getBooks().map { success ->
            success.map {
                BookDomainModel(
                    title = it.title,
                    author = it.author,
                    date = it.firstPublished,
                    shortSynopsis = it.shortSynopsis,
                    image = it.image,
                    score = it.score,
                    genres = it.genres
                )
            }
        }
}
