package com.example.fitproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.model.ExercisesModel
import com.example.fitproject.NewExerciseFragment
import com.example.fitproject.R

class RecyclerViewAdapter(var context: NewExerciseFragment, var exercisesList: ArrayList<ExercisesModel>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.add_exersice_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = exercisesList[position]
        viewHolder.itemView.findViewById<TextView>(R.id.tv_exersiceItem).text = item.exerciseName
        viewHolder.itemView.findViewById<ImageView>(R.id.iv_exerciseItem).setImageResource(item.exerciseImage)

    }

    override fun getItemCount(): Int {
        return exercisesList.size
    }
}