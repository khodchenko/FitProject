package com.example.fitproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitproject.R
import com.example.fitproject.model.Day

class DateRecyclerAdapter (private val day:List<Day>)
    : RecyclerView.Adapter<DateRecyclerAdapter.ViewHolder>() {

    private val items : MutableList<CardView>

    init{
        this.items = ArrayList()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDay: TextView
        val tvDayOfWeek: TextView
        val card: CardView
        init {
            // Define click listener for the ViewHolder's View.
            tvDay = view.findViewById(R.id.tv_day)
            tvDayOfWeek = view.findViewById(R.id.tv_dayofweek)
            card = view.findViewById(R.id.card_view_day)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DateRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.calendardate_item, viewGroup, false)

        return DateRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvDay.text = day[position].day.toString()
        viewHolder.tvDayOfWeek.text = day[position].dayOfWeek

        items.add(viewHolder.card)

    }

    override fun getItemCount(): Int {
        return day.size
    }

}