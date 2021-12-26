package com.example.fitproject.model

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import com.example.fitproject.R

data class Exercise(
    var id: Long,
    val name: String,
    @DrawableRes
    val image: Int,
    val description: String
) {
    companion object {

        fun createBaseList(numExercises: Int): ArrayList<Exercise> {
            val exercise = ArrayList<Exercise>()
            var i =0
            while (i != numExercises){
                exercise.add(Exercise(numExercises.toLong(),"TEST ${i}",R.drawable.ic_home,"TEST" ))
                i++
            }



            return exercise
        }

        fun addNewExercise(imageResource: Drawable, exerciseName: String) {
            val exercise = ArrayList<Exercise>()
            exercise.add(Exercise(1,exerciseName,R.drawable.ic_home,"TEST" ))
        }
    }
}