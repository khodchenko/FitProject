package com.example.fitproject.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.R
import com.example.fitproject.model.Exercise
import com.example.fitproject.model.ExerciseService


class RecyclerViewAdapter(
    var dataSet: List<Exercise>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.tv_exersiceItem)
            imageView = view.findViewById(R.id.iv_exerciseItem)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.add_exersice_item, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = dataSet[position]

        viewHolder.imageView.tag = dataSet //click

        viewHolder.textView.text = currentItem.name
        viewHolder.imageView.setImageResource(currentItem.image)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size



}
