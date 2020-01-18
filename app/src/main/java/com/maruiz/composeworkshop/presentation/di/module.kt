package com.maruiz.composeworkshop.presentation.di

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.ImageLoaderBuilder
import com.maruiz.composeworkshop.presentation.viewmodel.BookDetailViewModel
import com.maruiz.books.presentation.viewmodel.BooksViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { BooksViewModel(get()) }
    viewModel { BookDetailViewModel() }
    single { ImageLoaderBuilder(androidContext()).build() }
    factory { (fragment: Fragment) -> fragment.findNavController() }
}