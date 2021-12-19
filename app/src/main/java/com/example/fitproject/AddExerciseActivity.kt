package com.example.fitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.adapters.RecyclerViewAdapter

class AddExerciseActivity : AppCompatActivity() {

    lateinit var exercisesList: ArrayList<Exercises>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_exercise)

        // Lookup the recyclerview in activity layout
        val exercisesRecyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView

        // Initialize exercises
        exercisesList = Exercises.createEmptyList(20)
        // Create adapter passing in the sample user data
        val adapter = RecyclerViewAdapter(exercisesList)
        // Attach the adapter to the recyclerview to populate items
        exercisesRecyclerView.adapter = adapter
        // Set layout manager to position the items
        exercisesRecyclerView.layoutManager = LinearLayoutManager(this)
        

    }
}