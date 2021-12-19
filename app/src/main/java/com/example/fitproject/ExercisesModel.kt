package com.example.fitproject

data class ExercisesModel(val exerciseImage: Int, val exerciseName: String) {
    companion object {
        private var lastExerciseId = 0


        fun createEmptyList(numExercises: Int): ArrayList<ExercisesModel> {
            val exercise = ArrayList<ExercisesModel>()
            for (i in 1..numExercises) {
                exercise.add(ExercisesModel(R.drawable.ic_home, "TEST ${numExercises + 1}"))
            }
            return exercise
        }
    }
}