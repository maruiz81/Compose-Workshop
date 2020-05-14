package com.maruiz.composeworkshop.data.extensions

import android.util.Log
import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.core.flatMap
import com.maruiz.composeworkshop.data.error.Failure
import retrofit2.Call

suspend fun <R> Call<R>.makeCall(default: R): Either<Failure, R> =
    Either.catch({
        Log.e(TAG, "Error in call", it)
        Failure.GenericError
    }, suspend { this.execute() })
        .flatMap {
            if (it.isSuccessful) Right(it.body() ?: default)
            else Left(Failure.GenericError)
        }

private const val TAG = "CallExtension"