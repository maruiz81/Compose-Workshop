package com.maruiz.composeworkshop.presentation.view.ui

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.WithDensity
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography
import androidx.ui.material.surface.Surface
import androidx.ui.res.stringResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.maruiz.composeworkshop.R
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import com.maruiz.composeworkshop.presentation.view.states.BooksState

private val starColor = Color(0xFFFCCB22)

@Composable
fun PaintBooks(booksState: BooksState) {
    MyAppTheme {
        val typography = MaterialTheme.typography()
        Column {
            booksState.books.forEach {
                MainSection(it.title, it.author, it.date, it.score, typography)
                SynopsisSection(it.shortSynopsis, typography)
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
    score: Float,
    typography: Typography
) {
    Surface {
        Row(modifier = LayoutWidth.Fill) {
            Column(modifier = LayoutPadding(16.dp)) {
                Text(title, style = typography.h5)
                Text(author, style = typography.h6)
                Text(date, style = typography.body1)
            }
            Column(modifier = LayoutPadding(16.dp)) {
                Row {
                    Text("Score:")
                    Text(score.toString())
                }
                Row {
                    (1..score.toInt()).forEach {
                        SimpleVector(R.drawable.ic_baseline_star_24, starColor)
                    }
                    if ((score - score.toInt()) > 0)
                        SimpleVector(R.drawable.ic_baseline_star_half_24, starColor)
                }
            }
        }

    }
}

//TODO This is a temporal solution to import vector. I hope this is fixed in future versions
@Composable
fun SimpleVector(@DrawableRes id: Int, tint: Color = Color.Transparent) {
    val vector = vectorResource(id)
    WithDensity {
        Container(
            width = vector.defaultWidth,
            height = vector.defaultHeight
        ) {
            DrawVector(vector, tint)
        }
    }
}

@Composable
private fun SynopsisSection(synopsis: String, typography: Typography) {
    Text(synopsis, style = typography.body1, modifier = LayoutPadding(16.dp, 16.dp, 16.dp, 8.dp))
    Divider(color = Color.LightGray)
}

@Composable
private fun GenresSection(genres: List<String>, typography: Typography) {
    Column(modifier = LayoutPadding(8.dp)) {
        Text(stringResource(R.string.genres_title), style = typography.h5)
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
            "1605", shortSynopsis = "Bla bla bla",
            score = 4.5f,
            genres = listOf("genre 1", "genre 2")
        )
    )