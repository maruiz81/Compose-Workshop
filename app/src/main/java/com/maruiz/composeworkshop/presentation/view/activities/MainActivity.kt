package com.maruiz.composeworkshop.presentation.view.activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.maruiz.composeworkshop.presentation.view.ui.PaintList
import com.maruiz.composeworkshop.presentation.viewmodel.BooksViewModel
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
