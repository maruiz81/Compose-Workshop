package com.maruiz.composeworkshop.presentation.view.activities

import BooksViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.ui.core.setContent
import com.maruiz.composeworkshop.presentation.view.states.BooksState
import com.maruiz.composeworkshop.presentation.view.ui.PaintBooks
import com.maruiz.composeworkshop.presentation.view.ui.PaintList
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val booksViewModel: BooksViewModel by viewModel()

    private val booksState = BooksState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PaintList(booksState)
        }

        getBooks()
    }

    private fun getBooks() {
        booksViewModel.run {
            observeBooks().observe(this@MainActivity, Observer {
                booksState.books = it
            })
            requestBooks()
        }
    }
}
