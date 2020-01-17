package com.maruiz.composeworkshop.domain.di

import com.maruiz.composeworkshop.domain.usecases.GetBooks
import org.koin.dsl.module

val domainModule = module {
    factory { GetBooks(get()) }
}