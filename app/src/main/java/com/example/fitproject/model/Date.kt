package com.example.fitproject.model

import java.util.*

data class Date(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<Date>{
    override fun compareTo(other: Date): Int {
        if (year!=other.year) return year - other.year
        if (month!=other.month) return month - other.month
        return dayOfMonth - other.dayOfMonth
    }
    fun Date.followingDate() : Date {
        val c = Calendar.getInstance()
        c.set(year,month,dayOfMonth)
        val millisecondsInADay = 24*60*60*1000L
        val timeInMillis = c.timeInMillis + millisecondsInADay
        val result = Calendar.getInstance()
        result.timeInMillis = timeInMillis
        return Date(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
    }
}