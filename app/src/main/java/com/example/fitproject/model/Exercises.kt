package com.example.fitproject.model

import android.content.res.Resources
import com.example.fitproject.R
import java.io.Serializable

class Exercises(private val exercises: Array<Exercise>) : Serializable {

    fun get(): Array<Exercise>{
        return exercises
    }

    fun getExerciseById(exerciseId: Long): Exercise? = exercises.firstOrNull { it.id == exerciseId }


    /* Returns initial list of exercises. */
    fun exerciseList(resources: Resources): List<Exercise> {
        return listOf(
            Exercise(
                id = 1,
                name = resources.getString(R.string.exercise1_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise1_description)
            ),
            Exercise(
                id = 2,
                name = resources.getString(R.string.exercise2_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise2_description)
            ),
            Exercise(
                id = 3,
                name = resources.getString(R.string.exercise3_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise3_description)
            ),
            Exercise(
                id = 4,
                name = resources.getString(R.string.exercise4_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise4_description)
            ),
            Exercise(
                id = 5,
                name = resources.getString(R.string.exercise5_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise5_description)
            ),
            Exercise(
                id = 6,
                name = resources.getString(R.string.exercise6_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise6_description)
            ),
            Exercise(
                id = 7,
                name = resources.getString(R.string.exercise7_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise7_description)
            ),
            Exercise(
                id = 8,
                name = resources.getString(R.string.exercise8_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise8_description)
            ),
            Exercise(
                id = 9,
                name = resources.getString(R.string.exercise9_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise9_description)
            ),
            Exercise(
                id = 10,
                name = resources.getString(R.string.exercise10_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise10_description)
            ),
            Exercise(
                id = 11,
                name = resources.getString(R.string.exercise11_name),
                image = R.drawable.ic_calendar,
                description = resources.getString(R.string.exercise11_description)
            )
        )
    }
}