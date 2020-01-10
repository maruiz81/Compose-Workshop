package com.maruiz.composeworkshop.data.extensions

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.core.flatMap
import com.maruiz.composeworkshop.data.error.Failure
import retrofit2.Call

suspend fun <R> Call<R>.makeCall(default: R): Either<Failure, R> =
    Either.catch({ Failure.GenericError }, suspend { this.execute() })
        .flatMap {
            if (it.isSuccessful) Right(it.body() ?: default)
            else Left(Failure.GenericError)
        }