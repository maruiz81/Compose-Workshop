package com.maruiz.composeworkshop.data.di

import com.maruiz.composeworkshop.data.repository.BookRepository
import org.koin.dsl.module

val dataModule = module {
    single { BookRepository() }
}