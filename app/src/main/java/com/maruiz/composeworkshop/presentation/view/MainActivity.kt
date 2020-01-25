package com.maruiz.composeworkshop.presentation.view

import BooksViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.Observer
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.tooling.preview.Preview
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val booksViewModel: BooksViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PaintBooks(emptyList())
        }

        getBooks()
    }

    @Composable
    fun PaintBooks(books: List<BookPresentationModel>) {
        Column() {
            books.forEach {
                Text(it.title)
                Text(it.author)
                Text(it.date)
            }
        }
    }

    @Preview
    @Composable
    fun preview() {
        PaintBooks(previewBook())
    }

    private fun getBooks() {
        booksViewModel.run {
            observeBooks().observe(this@MainActivity, Observer {
                PaintBooks(it)
            })
            requestBooks()
        }
    }

    private fun previewBook() =
        listOf(
            BookPresentationModel(
                "Don Quixote", "Miguel de Cervantes",
                "1605"
            )
        )
}
