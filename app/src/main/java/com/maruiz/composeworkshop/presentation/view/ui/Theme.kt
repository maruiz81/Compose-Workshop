package com.maruiz.composeworkshop.presentation.view.ui

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.lightColorPalette


private val clearBlue = Color(0xFFBBE1FA)
private val darkBlue = Color(0xFF3282B8)
private val themeColors = lightColorPalette(
    primary = darkBlue,
    surface = clearBlue
)

@Composable
fun MyAppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        children()
    }
}