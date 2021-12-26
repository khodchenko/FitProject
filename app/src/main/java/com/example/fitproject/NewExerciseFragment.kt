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
import com.example.fitproject.model.Exercise


class NewExerciseFragment : Fragment() {

    companion object{
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
    var exercisesList = mutableListOf<Exercise>()
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
        binding = FragmentNewExerciseBinding.bind(view)




        recyclerAdapter = RecyclerViewAdapter(Exercise.createBaseList(20))
        recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = recyclerAdapter
        recyclerview.setHasFixedSize(true)


    }
}

