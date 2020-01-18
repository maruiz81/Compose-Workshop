package com.maruiz.composeworkshop.presentation.presentationmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookDetailPresentationModel(
    val title: String = "", val author: String = "",
    val synopsis: String = "", val image: String = ""
) : Parcelable