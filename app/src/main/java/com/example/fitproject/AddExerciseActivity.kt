package com.example.fitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.adapters.RecyclerViewAdapter


class AddExerciseActivity : AppCompatActivity(),NoticeDialogFragment.NoticeDialogListener {

    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var exercisesList: ArrayList<ExercisesModel>
    private lateinit var recyclerview: RecyclerView
    private lateinit var addNewExerciseButton : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_exercise)
        init()
        addNewExerciseButton = findViewById(R.id.ib_addNewExercise)
        addNewExerciseButton.setOnClickListener {
            addNewExercise()
        }

    }

    private fun init(){
        exercisesList = ArrayList(ExercisesModel.createBaseList(20))
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerAdapter = RecyclerViewAdapter(this, exercisesList)
        recyclerview = findViewById(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = recyclerAdapter
        recyclerview.setHasFixedSize(true)
    }

    private fun addNewExercise(){
        val dialog = NoticeDialogFragment()
        dialog.show(supportFragmentManager, "NoticeDialogFragment")
        //Todo how to add new items from dialog
        recyclerAdapter.notifyDataSetChanged()
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        TODO("Not yet implemented")
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        TODO("Not yet implemented")
    }
}