package com.example.fitproject

data class ExercisesModel(val exerciseImage: Int, val exerciseName: String) {
    companion object {

        fun createBaseList(numExercises: Int): ArrayList<ExercisesModel> {
            val exercise = ArrayList<ExercisesModel>()
            exercise.add(ExercisesModel(R.drawable.ic_home, "TEST 1"))
            exercise.add(ExercisesModel(R.drawable.ic_home, "TEST 2"))
            exercise.add(ExercisesModel(R.drawable.ic_home, "TEST 3"))
            exercise.add(ExercisesModel(R.drawable.ic_home, "TEST 4"))

            return exercise
        }
    }
}