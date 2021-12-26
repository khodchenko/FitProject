package com.example.fitproject.model

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Handles operations on exerciseLiveData and holds details about it. */
class DataSource(resources: Resources) {
    private val initialExerciseList = exerciseList(resources)
    private val exerciseLiveData = MutableLiveData(initialExerciseList)

    /* Adds exercise to liveData and posts value. */
    fun addExercise(exercise: Exercise) {
        val currentList = exerciseLiveData.value
        if (currentList == null) {
            exerciseLiveData.postValue(listOf(exercise))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, exercise)
            exerciseLiveData.postValue(updatedList)
        }
    }

    /* Removes exercise from liveData and posts value. */
    fun removeExercise(exercise: Exercise) {
        val currentList = exerciseLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(exercise)
            exerciseLiveData.postValue(updatedList)
        }
    }


    /* Returns exercise given an ID. */
//    fun getExerciseForId(id: Long): Exercise? {
//        exerciseLiveData.value?.let { exercise ->
//            return exercise.firstOrNull { it.id == id }
//        }
//        return null
//    }

    fun getExerciseList(): LiveData<List<Exercise>> {
        return exerciseLiveData
    }

    /* Returns a random exercise asset for exercises that are added. */
    fun getRandomExerciseImageAsset(): Int? {
        val randomNumber = (initialExerciseList.indices).random()
        return initialExerciseList[randomNumber].image
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }


}