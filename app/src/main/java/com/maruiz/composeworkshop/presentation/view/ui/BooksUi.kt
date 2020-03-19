package com.maruiz.composeworkshop.presentation.view.ui

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Image
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.drawVector
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.Typography
import androidx.ui.res.imageResource
import androidx.ui.res.stringResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.maruiz.composeworkshop.R
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import com.maruiz.composeworkshop.presentation.view.states.BooksState

@Composable
fun PaintList(booksState: BooksState) {
    MyAppTheme {
        AdapterList(data = booksState.books) { item ->
            PaintBooks(item, MaterialTheme.typography())
        }
    }
}

@Composable
fun PaintBooks(book: BookPresentationModel, typography: Typography) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = LayoutPadding(8.dp)
    ) {
        Column {
            Row(modifier = LayoutWidth.Fill) {
                CoverImage(book.image)
                MainSection(book.title, book.author, book.date, typography)
            }
            SynopsisSection(book.shortSynopsis, typography)
            Row {
                //Layout flexible can't be in nested function, needs to be in the same
                //function than Row
                Column(modifier = LayoutPadding(8.dp) + LayoutWeight(1f)) {
                    PaingGenreTitle(typography)
                    PaintGenres(book, typography)
                }
                PainScore(book.score, typography)
            }
        }
    }
}

@Composable
private fun PaingGenreTitle(typography: Typography) {
    Text(
        stringResource(R.string.genres_title),
        style = typography.h5
    )
}

@Composable
private fun PaintGenres(
    it: BookPresentationModel,
    typography: Typography
) {
    it.genres.forEach {
        Text(
            text = "- $it",
            style = typography.body1,
            modifier = LayoutPadding(start = 8.dp)
        )
    }
}

@Composable
private fun CoverImage(imageUrl: String) {
    val image = imageResource(getImage(imageUrl))
    val ratio = image.width.toFloat() / image.height.toFloat()
    Container(
        modifier = LayoutHeight.Constrain(0.dp, 120.dp)
                + LayoutAspectRatio(aspectRatio = ratio)
    ) {
        Image(image)
    }
}

@Composable
private fun MainSection(
    title: String,
    author: String,
    date: String,
    typography: Typography
) {
    Column(modifier = LayoutPadding(16.dp)) {
        Text(title, style = typography.h5)
        Text(author, style = typography.h6)
        Text(date, style = typography.body1)
    }
}

@Composable
fun PainScore(score: Float, typography: Typography) {
    Column(modifier = LayoutPadding(16.dp)) {
        Row {
            Text(stringResource(R.string.score_title), modifier = LayoutGravity.Center)
            Text(score.toString(), style = typography.h6, modifier = LayoutPadding(start = 8.dp))
        }
        Row {
            val starColor = Color(0xFFFCCB22)
            (1..score.toInt()).forEach { _ ->
                SimpleVector(R.drawable.ic_baseline_star_24, starColor)
            }
            ((score.toInt() + 1)..5).forEach {
                if ((it - score.toInt()) in 0..1)
                    SimpleVector(R.drawable.ic_baseline_star_half_24, starColor)
                else
                    SimpleVector(R.drawable.ic_baseline_star_border_24, starColor)
            }
        }
    }
}

//TODO This is a temporal solution to import vector. I hope this is fixed in future versions
@Composable
fun SimpleVector(@DrawableRes id: Int, tint: Color = Color.Transparent) {
    val vector = vectorResource(id)
    Box(
        modifier = LayoutSize(vector.defaultWidth, vector.defaultHeight) + drawVector(vector, tint)
    )
}

@Composable
private fun SynopsisSection(synopsis: String, typography: Typography) {
    Text(synopsis, style = typography.body1, modifier = LayoutPadding(16.dp, 16.dp, 16.dp, 8.dp))
    Divider(color = Color.LightGray)
}

@Preview
@Composable
fun preview() {
    PaintList(
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
            score = 3.5f,
            genres = listOf("genre 1", "genre 2")
        ),
        BookPresentationModel(
            "Odissey", "Homer", "-2000",
            shortSynopsis = "Bla bla bla", score = 4f,
            genres = listOf("genre 1", "genre 2")
        )
    )