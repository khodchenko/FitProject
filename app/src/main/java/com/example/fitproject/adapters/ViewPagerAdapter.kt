package com.example.fitproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.R

class ViewPagerAdapter(private val dates: List<String>): RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val dateTitle : TextView = itemView.findViewById(R.id.date_tv)

        init {
            //todo click to comeback on current date
            dateTitle.setOnClickListener {
                 val position : Int = adapterPosition
                Toast.makeText(itemView.context, "You cliked on iten ${position+1 }", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
      holder.dateTitle.text = dates[position]

    }

    override fun getItemCount(): Int {
        return dates.size
    }
}