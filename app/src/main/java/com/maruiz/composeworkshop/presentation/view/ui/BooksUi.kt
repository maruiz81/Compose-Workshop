package com.maruiz.composeworkshop.presentation.view.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.ambientOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.maruiz.composeworkshop.R
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import dev.chrisbanes.accompanist.coil.CoilImage

val Typography = ambientOf<Typography> { error("Typography not selected") }

@Composable
fun PaintList(books: List<BookPresentationModel>) {
    MyAppTheme {
        Providers(Typography provides MaterialTheme.typography) {
            LazyColumnFor(items = books) { item ->
                PaintBooks(item)
            }
        }
    }
}

@Composable
fun PaintBooks(book: BookPresentationModel) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                CoverImage(book.image)
                MainSection(book.title, book.author, book.date)
            }
            SynopsisSection(book.shortSynopsis)
            Row {
                //Layout flexible can't be in nested function, needs to be in the same
                //function than Row
                Column(modifier = Modifier.padding(8.dp).then(Modifier.weight(1f))) {
                    PaintGenreTitle()
                    PaintGenres(book)
                }
                PainScore(book.score)
            }
        }
    }
}

@Composable
private fun PaintGenreTitle() {
    Text(
        stringResource(R.string.genres_title),
        style = Typography.current.h5
    )
}

@Composable
private fun PaintGenres(
    it: BookPresentationModel
) {
    it.genres.forEach {
        Text(
            text = "- $it",
            style = Typography.current.body1,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun CoverImage(imageUrl: String) {
    CoilImage(data = imageUrl, modifier = Modifier.width(80.dp).then(Modifier.height(124.dp)))
}

@Composable
private fun MainSection(
    title: String,
    author: String,
    date: String
) {
    val typo = Typography.current
    Column(modifier = Modifier.padding(16.dp)) {
        Text(title, style = typo.h5)
        Text(author, style = typo.h6)
        Text(date, style = typo.body1)
    }
}

@Composable
fun PainScore(score: Float) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            Text(
                stringResource(R.string.score_title),
                modifier = Modifier.gravity(Alignment.CenterVertically)
            )
            Text(
                score.toString(),
                style = Typography.current.h6,
                modifier = Modifier.padding(start = 8.dp)
            )
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
        modifier = Modifier.preferredSize(vector.defaultWidth, vector.defaultHeight)
            .then(Modifier.paint(VectorPainter(vector), colorFilter = ColorFilter.tint(tint)))
    )
}

@Composable
private fun SynopsisSection(synopsis: String) {
    Text(
        synopsis,
        style = Typography.current.body1,
        modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 8.dp)
    )
    Divider(color = Color.LightGray)
}

@Preview
@Composable
fun preview() {
    PaintList(
        previewBook()
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
            shortSynopsis = "Bla bla bla",
            score = 4f,
            genres = listOf("genre 1", "genre 2")
        )
    )