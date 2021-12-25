package com.example.fitproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitproject.R
import com.example.fitproject.databinding.AddExersiceItemBinding
import com.example.fitproject.model.Exercise
import com.example.fitproject.model.ExercisesModel

class RecyclerViewAdapter() :  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    private val dataSet: ArrayList<ExercisesModel> = ExercisesModel.createBaseList(20)

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
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = currentItem.exerciseName
        viewHolder.imageView.setImageResource(currentItem.exerciseImage)  //todo change to specific image
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
