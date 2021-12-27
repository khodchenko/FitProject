package com.example.fitproject


import android.annotation.SuppressLint
import android.app.AlertDialog
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
    var exercisesList = mutableListOf<Exercise>()
    private lateinit var recyclerview: RecyclerView
    private lateinit var addNewExerciseButton: ImageButton
    val listOfItems = mutableListOf<Exercise>()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewExerciseBinding.bind(view)


        createBaseList()



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
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    private fun createBaseList() {
        var index = 0
        while (index < 100){
            listOfItems.add(Exercise(index.toLong(),"TEST $index",R.drawable.base_exercise,"test"))
            index++
        }
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
                listOfItems.add(Exercise((listOfItems.lastIndex)+1.toLong(),name,R.drawable.base_exercise,"test"))
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

