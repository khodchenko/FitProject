package com.example.fitproject.model

import androidx.annotation.DrawableRes

data class Exercise (
    var id: Long,
    val name: String,
    @DrawableRes
    val image: Int,
    val description: String
)