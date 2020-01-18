package com.maruiz.composeworkshop.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maruiz.composeworkshop.presentation.presentationmodel.BookDetailPresentationModel
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel

class BookDetailViewModel : BaseViewModel() {
    private val book = MutableLiveData<BookDetailPresentationModel>()
    fun observeBook(): LiveData<BookDetailPresentationModel> = book

    fun showBook(bookReceived: BookPresentationModel) {
        book.value = BookDetailPresentationModel(
            title = bookReceived.title,
            author = bookReceived.author,
            image = bookReceived.image,
            synopsis = bookReceived.synopsis
        )
    }
}