package com.maruiz.composeworkshop.presentation.view.ui

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography
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
                MainSection(it.title, it.author, it.date, typography)
                GenresSection(it.genres, typography)
            }
        }
    }
}

@Composable
private fun MainSection(
    title: String,
    author: String,
    date: String,
    typography: Typography
) {
    Surface {
        Column(modifier = LayoutPadding(16.dp) + LayoutWidth.Fill) {
            Text(title, style = typography.h5)
            Text(author, style = typography.h6)
            Text(date, style = typography.body1)
        }
    }
}

@Composable
private fun GenresSection(genres: List<String>, typography: Typography) {
    Column(modifier = LayoutPadding(16.dp)) {
        genres.forEach { Text(text = it, style = typography.body1) }
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
            "1605", genres = listOf("genre 1", "genre 2")
        )
    )