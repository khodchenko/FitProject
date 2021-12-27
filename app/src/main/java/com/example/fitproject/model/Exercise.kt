package com.example.fitproject.model

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import com.example.fitproject.R

data class Exercise(
    val id : Long,
    val name: String,
    @DrawableRes
    val image: Int,
    val description: String
)