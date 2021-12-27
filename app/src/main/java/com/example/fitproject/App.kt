package com.example.fitproject

import android.app.Application
import com.example.fitproject.model.ExerciseService

class App : Application() {

    val exerciseService = ExerciseService()
}