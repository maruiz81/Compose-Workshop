package com.maruiz.composeworkshop.presentation.view.ui

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutPadding
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import com.maruiz.composeworkshop.presentation.view.states.BooksState

@Composable
fun PaintBooks(booksState: BooksState) {
    Column {
        booksState.books.forEach {
            Column(LayoutPadding(16.dp)) {
                Text(it.title)
                Text(it.author)
                Text(it.date)
            }
        }
    }
}

@Preview
@Composable
fun preview() {
    PaintBooks(
        BooksState(
            previewBook()
        )
    )
}

private fun previewBook() =
    listOf(
        BookPresentationModel(
            "Don Quixote", "Miguel de Cervantes",
            "1605"
        )
    )