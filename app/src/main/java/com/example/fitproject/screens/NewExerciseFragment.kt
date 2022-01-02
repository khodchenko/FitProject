package com.example.fitproject.screens


import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.adapters.RecyclerViewAdapter
import com.example.fitproject.databinding.FragmentNewExerciseBinding
import com.example.fitproject.model.Exercise
import androidx.appcompat.app.AppCompatActivity
import com.example.fitproject.MainActivity
import com.example.fitproject.R

const val APP_PREFERENCES = "APP_PREFERENCES"
const val PREF_EXERCISE_VALUE = "PREF_EXERCISE_VALUE"

class NewExerciseFragment : Fragment(R.layout.fragment_new_exercise) {


    companion object {
        @JvmStatic
        fun newInstance(): NewExerciseFragment {
            val args = Bundle().apply {
                //putInt (key,value)
                //putString (key, value)
            }
            val fragment = NewExerciseFragment()
            fragment.arguments = args
            return fragment
        }
    }


    private lateinit var binding: FragmentNewExerciseBinding

    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var recyclerview: RecyclerView
    //private lateinit var addNewExerciseButton: ImageButton
    private val listOfItems = mutableListOf<Exercise>()
    private lateinit var preferences: SharedPreferences




    @SuppressLint("FragmentBackPressedCallback")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewExerciseBinding.bind(view)

        (activity as AppCompatActivity?)!!.supportActionBar?.title = "Add New Exercise"
        (activity as AppCompatActivity?)!!.supportActionBar?.customView = binding.toolbar2


        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        createBaseList()


        //recycler view
        recyclerAdapter = RecyclerViewAdapter(listOfItems)
        recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = recyclerAdapter
       // recyclerview.setHasFixedSize(true)

        binding.ibAddNewExercise.setOnClickListener {
            addNewExercise()
        }
    }

    override fun onResume() {
        super.onResume()

    }

    private fun createBaseList() {
        var index = 0

        listOfItems.add(Exercise(index.toLong(),
            preferences.getString(PREF_EXERCISE_VALUE, "").toString(), R.drawable.base_exercise,"test"))

    }

    @SuppressLint("InflateParams", "NotifyDataSetChanged")
    private fun addNewExercise(){
        val inflater = LayoutInflater.from(activity)
        val inflated = inflater.inflate(R.layout.dialog_add_exercise, null)
        val imageChooseButton = inflated.findViewById<Button>(R.id.button_addImage)
        val editText = inflated.findViewById<EditText>(R.id.editText_addExerciseName)


        val addDialog = AlertDialog.Builder(activity)
        addDialog.setView(inflated)
            .setPositiveButton("Confirm"){
                addDialog,_ ->
               // val image =
                val name = editText.text.toString()
                listOfItems.add(Exercise((listOfItems.lastIndex)+1.toLong(),name,
                    R.drawable.base_exercise,"test"))
                preferences.edit()
                    .putString(PREF_EXERCISE_VALUE, name)
                    .apply()
                recyclerAdapter.notifyDataSetChanged()
                addDialog.dismiss()
            }
            .setNegativeButton("Cancel"){
                addDialog,_->
                addDialog.dismiss()
            }
            .create()
            .show()

    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }


}

