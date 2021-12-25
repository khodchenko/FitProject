package com.example.fitproject

import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.adapters.RecyclerViewAdapter
import com.example.fitproject.model.ExercisesModel


class NewExerciseFragment : Fragment(R.layout.fragment_new_exercise) {

    companion object {
        const val REQUEST_KEY = "parent-request-key"
        const val KEY_NUMBER = "key-number"
    }

    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var exercisesList: ArrayList<ExercisesModel>
    private lateinit var recyclerview: RecyclerView
    private lateinit var addNewExerciseButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        addNewExerciseButton = requireView().findViewById(R.id.ib_addNewExercise)
        addNewExerciseButton.setOnClickListener {
            addNewExercise()
        }
    }


    private fun init() {
        exercisesList = ArrayList(ExercisesModel.createBaseList(20))
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerAdapter = RecyclerViewAdapter(this, exercisesList)
        recyclerview = requireView().findViewById(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(NewExerciseFragment::class.java)
        recyclerview.adapter = recyclerAdapter
        recyclerview.setHasFixedSize(true)
    }


    private fun addNewExercise() {


    }



}

