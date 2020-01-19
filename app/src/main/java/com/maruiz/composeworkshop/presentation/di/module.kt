package com.maruiz.composeworkshop.presentation.di

import BooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { BooksViewModel(get()) }
}