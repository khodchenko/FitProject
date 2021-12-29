package com.example.fitproject.common

abstract class BaseVieLogic<T> {
    private var isCancelled = false

    fun  onCancel(){
        isCancelled = true
    }


    abstract fun onViewEvent(event: T)
}