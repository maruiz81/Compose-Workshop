package com.maruiz.composeworkshop.presentation.di

import com.maruiz.composeworkshop.presentation.viewmodel.BooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { BooksViewModel(get()) }
}