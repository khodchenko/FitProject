package com.example.fitproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.Exercises
import com.example.fitproject.R

class RecyclerViewAdapter (private val exercisesList: List<Exercises>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exercisesImage = itemView.findViewById<ImageView>(R.id.iv_exerciseItem)
        val exercisesName = itemView.findViewById<TextView>(R.id.tv_exersiceItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.add_exersice_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val exercise: Exercises = exercisesList[position]
        val exercisesImage = viewHolder.exercisesImage
        exercisesImage.setImageResource(exercise.exerciseImage)
        val exercisesName = viewHolder.exercisesName
        exercisesName.text = exercise.exerciseName
    }

    override fun getItemCount(): Int {
        return exercisesList.size
    }
}