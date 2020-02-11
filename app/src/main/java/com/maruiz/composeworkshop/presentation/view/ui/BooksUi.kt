package com.maruiz.composeworkshop.presentation.view.ui

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import com.maruiz.composeworkshop.presentation.view.states.BooksState

@Composable
fun PaintBooks(booksState: BooksState) {
    MyAppTheme {
        val typography = MaterialTheme.typography()
        Column {
            booksState.books.forEach {
                Surface {
                    Column(modifier = LayoutPadding(16.dp) + LayoutWidth.Fill) {
                        Text(it.title, style = typography.h5)
                        Text(it.author, style = typography.h6)
                        Text(it.date, style = typography.body1)
                    }
                }
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