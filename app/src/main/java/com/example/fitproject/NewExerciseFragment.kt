package com.example.fitproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.adapters.RecyclerViewAdapter
import com.example.fitproject.databinding.FragmentNewExerciseBinding
import com.example.fitproject.model.DataSource
import com.example.fitproject.model.ExercisesModel


class NewExerciseFragment : Fragment() {

    private lateinit var binding: FragmentNewExerciseBinding
    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var exercisesList: ArrayList<ExercisesModel>
    private lateinit var recyclerview: RecyclerView
    private lateinit var addNewExerciseButton: ImageButton


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: DataSource
        val recyclerAdapter = RecyclerViewAdapter(exercisesList)
        val layoutManager = LinearLayoutManager(activity)
        recyclerAdapter.layoutManager = layoutManager
        recyclerAdapter.adapter = recyclerAdapter

    }
}

