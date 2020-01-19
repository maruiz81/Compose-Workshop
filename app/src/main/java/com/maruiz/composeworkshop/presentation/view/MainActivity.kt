package com.maruiz.composeworkshop.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Hello()
        }
    }

    @Composable
    fun Hello() {
        Text("Hello, World!")
    }

    @Preview
    @Composable
    fun preview() {
        Hello()
    }
}