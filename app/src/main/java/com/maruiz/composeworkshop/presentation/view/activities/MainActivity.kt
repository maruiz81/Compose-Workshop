package com.maruiz.composeworkshop.presentation.view.activities

import BooksViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.getValue
import androidx.ui.core.setContent
import androidx.ui.livedata.observeAsState
import com.maruiz.composeworkshop.presentation.view.ui.PaintList
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val booksViewModel: BooksViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val books by booksViewModel.books.observeAsState(initial = emptyList())

            PaintList(books)
        }

        booksViewModel.requestBooks()
    }
}
