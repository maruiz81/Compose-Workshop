package com.maruiz.composeworkshop.domain.usecases

import arrow.core.Either
import arrow.core.Right
import com.maruiz.composeworkshop.data.error.Failure
import com.maruiz.composeworkshop.domain.model.BookModelDomainModel

class GetBooks() :
    UseCase<List<BookModelDomainModel>, Unit>() {
    override suspend fun run(params: Unit): Either<Failure, List<BookModelDomainModel>> =
        Right(listOf(BookModelDomainModel()))
}
