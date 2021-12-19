package com.example.fitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.adapters.RecyclerViewAdapter


class AddExerciseActivity : AppCompatActivity() {

    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var exercisesList: ArrayList<ExercisesModel>
    private lateinit var recyclerview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_exercise)

        init()


    }

    private fun init(){
        exercisesList = ArrayList()
        exercisesList.add(ExercisesModel(R.drawable.ic_home, "TEST"))
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerAdapter = RecyclerViewAdapter(this, exercisesList)
        recyclerview = findViewById(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = recyclerAdapter
        recyclerview.setHasFixedSize(true)
    }
}