package com.example.fitproject.model

import android.annotation.SuppressLint
import java.util.*
import java.util.Date
import kotlin.collections.ArrayList


data class Day (
    val day: Int,
    val dayOfWeek: String
        )
        {
    fun getPastDaysOnIntervalOf(times: Int, interval: Int): List<Date>? {
        // The list to be populated with the desired dates
        val list: MutableList<Date> = ArrayList()

        // Today
        val cal: Calendar = Calendar.getInstance()
        var date:Date = cal.time
        for (i in 1..times) {
            list.add(date)
            cal.add(Calendar.DATE, -interval)
            date = cal.getTime()
        }

        // Return the populated list
        return list
    }
}
