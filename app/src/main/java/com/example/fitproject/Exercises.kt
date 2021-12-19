package com.example.fitproject

data class Exercises(val exerciseImage: Int, val exerciseName: String) {
    companion object {
        private var lastExerciseId = 0


        fun createEmptyList(numExercises: Int): ArrayList<Exercises> {
            val contacts = ArrayList<Exercises>()
            for (i in 1..numExercises) {
                contacts.add(Exercises(R.drawable.ic_home, "TEST ${numExercises + 1}"))
            }
            return contacts
        }
    }
}