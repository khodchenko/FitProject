package com.example.fitproject.model

import com.example.fitproject.R
import com.github.javafaker.Faker
import java.util.*

typealias ExercisesListener = (exercises: List<Exercise>) -> Unit

class ExerciseService {

    private var exercises = mutableListOf<Exercise>()

    private val listeners = mutableSetOf<ExercisesListener>()

    init {
        val faker = Faker.instance()
        exercises = (1..100).map { Exercise(
            id = it.toLong(),
            name = faker.name().name(),
            description = faker.company().name(),
            image = R.drawable.base_exercise
        ) }.toMutableList()
    }

    fun getExercises(): List<Exercise> {
        return exercises
    }

    fun deleteExercise(exercise: Exercise) {
        val indexToDelete = exercises.indexOfFirst { it.id == exercise.id }
        if (indexToDelete != -1) {
            exercises.removeAt(indexToDelete)
            notifyChanges()
        }
    }

    fun moveExercise(exercise: Exercise, moveBy: Int) {
        val oldIndex = exercises.indexOfFirst { it.id == exercise.id }
        if (oldIndex == -1) return
        val newIndex = oldIndex + moveBy
        if (newIndex < 0 || newIndex >= exercises.size) return
        Collections.swap(exercises, oldIndex, newIndex)
        notifyChanges()
    }

    fun addListener(listener: ExercisesListener) {
        listeners.add(listener)
        listener.invoke(exercises)
    }

    fun removeListener(listener: ExercisesListener) {
        listeners.remove(listener)
    }

    private fun notifyChanges() {
        listeners.forEach { it.invoke(exercises) }
    }
}