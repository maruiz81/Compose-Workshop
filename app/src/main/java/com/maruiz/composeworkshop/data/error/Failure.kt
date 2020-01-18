package com.maruiz.composeworkshop.data.error

sealed class Failure {
    object GenericError : Failure()
}