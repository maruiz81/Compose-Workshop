package com.maruiz.composeworkshop.presentation.view.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val darkBlue = Color(0xFF3282B8)
private val themeColors = lightColors(
    primary = darkBlue
)

@Composable
fun MyAppTheme(children: @Composable () -> Unit) {
    MaterialTheme(colors = themeColors) {
        children()
    }
}