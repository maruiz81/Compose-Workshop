package com.maruiz.composeworkshop.domain.usecases

import arrow.core.Either
import com.maruiz.composeworkshop.data.error.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        clientScope: CoroutineScope,
        onResult: (Either<Failure, Type>) -> Unit
    ) {
        clientScope.launch {
            val backgroundTask = async(Dispatchers.Default) { run(params) }
            onResult(backgroundTask.await())
        }
    }
}