package com.maruiz.composeworkshop.presentation.view.states

import androidx.compose.Model
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel

@Model
class BooksState(var books: List<BookPresentationModel> = emptyList())