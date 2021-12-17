package com.example.fitproject.screens

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.fitproject.R
import com.example.fitproject.adapters.ViewPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment(R.layout.fragment_main) {

    private var datesList = mutableListOf<String>()

    companion object {
        const val userNameKey = "USER_NAME"
    }


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postToList()


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ViewPager2>(R.id.view_pager2).adapter =ViewPagerAdapter(datesList)
        view.findViewById<ViewPager2>(R.id.view_pager2).orientation = ViewPager2.ORIENTATION_HORIZONTAL

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

    //todo make it shorter
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

    private fun addToList(date:String){
        datesList.add(date)
    }

    private fun postToList(){
        for (i in 1..5){
            addToList("Tile $i")
        }
    }


}