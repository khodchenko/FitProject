package com.example.fitproject.screens

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.fitproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        const val userNameKey = "USER_NAME"
    }

    //todo  activity this
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            activity,
            R.anim.rotate_open_anim
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            activity,
            R.anim.rotate_close_anim
        )
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            activity,
            R.anim.from_bottom_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            activity,
            R.anim.to_bottom_anim
        )
    }

    private var fabClicked = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        view.findViewById<AppCompatTextView>(R.id.mainNameTextView).text = arguments?.getString(
            userNameKey
        )

        view.findViewById<FloatingActionButton>(R.id.fab_main).setOnClickListener {
            onFabClicked()
        }
        view.findViewById<FloatingActionButton>(R.id.fab_first).setOnClickListener {
            Toast.makeText(activity, "FIRST BUTTON CLICKED", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<FloatingActionButton>(R.id.fab_second).setOnClickListener {
            Toast.makeText(activity, "SECOND BUTTON CLICKED", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<FloatingActionButton>(R.id.fab_third).setOnClickListener {
            Toast.makeText(activity, "THIRD BUTTON CLICKED", Toast.LENGTH_SHORT).show()
        }

    }

    private fun onFabClicked() {
        setVisibility(fabClicked)
        setAnimation(fabClicked)
        fabClicked = !fabClicked
    }


    private fun setVisibility(fabClicked: Boolean) {
        if (!fabClicked) {
            view?.findViewById<FloatingActionButton>(R.id.fab_first)?.visibility = View.VISIBLE
            view?.findViewById<FloatingActionButton>(R.id.fab_second)?.visibility = View.VISIBLE
            view?.findViewById<FloatingActionButton>(R.id.fab_third)?.visibility = View.VISIBLE
            view?.findViewById<TextView>(R.id.textView)?.visibility = View.VISIBLE
            view?.findViewById<TextView>(R.id.textView2)?.visibility = View.VISIBLE
            view?.findViewById<TextView>(R.id.textView3)?.visibility = View.VISIBLE
        } else{
            view?.findViewById<FloatingActionButton>(R.id.fab_first)?.visibility = View.INVISIBLE
            view?.findViewById<FloatingActionButton>(R.id.fab_second)?.visibility = View.INVISIBLE
            view?.findViewById<FloatingActionButton>(R.id.fab_third)?.visibility = View.INVISIBLE
            view?.findViewById<TextView>(R.id.textView)?.visibility = View.INVISIBLE
            view?.findViewById<TextView>(R.id.textView2)?.visibility = View.INVISIBLE
            view?.findViewById<TextView>(R.id.textView3)?.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(fabClicked: Boolean) {
        if(!fabClicked){
            view?.findViewById<FloatingActionButton>(R.id.fab_first)?.startAnimation(fromBottom)
            view?.findViewById<FloatingActionButton>(R.id.fab_second)?.startAnimation(fromBottom)
            view?.findViewById<FloatingActionButton>(R.id.fab_third)?.startAnimation(fromBottom)
            view?.findViewById<TextView>(R.id.textView)?.startAnimation(fromBottom)
            view?.findViewById<TextView>(R.id.textView2)?.startAnimation(fromBottom)
            view?.findViewById<TextView>(R.id.textView3)?.startAnimation(fromBottom)
            view?.findViewById<FloatingActionButton>(R.id.fab_main)?.startAnimation(rotateOpen)
        }else{
            view?.findViewById<FloatingActionButton>(R.id.fab_first)?.startAnimation(toBottom)
            view?.findViewById<FloatingActionButton>(R.id.fab_second)?.startAnimation(toBottom)
            view?.findViewById<FloatingActionButton>(R.id.fab_third)?.startAnimation(toBottom)
            view?.findViewById<TextView>(R.id.textView)?.startAnimation(toBottom)
            view?.findViewById<TextView>(R.id.textView2)?.startAnimation(toBottom)
            view?.findViewById<TextView>(R.id.textView3)?.startAnimation(toBottom)
            view?.findViewById<FloatingActionButton>(R.id.fab_main)?.startAnimation(rotateClose)
        }
    }


}