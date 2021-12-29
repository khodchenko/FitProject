package com.example.fitproject.screens



import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.fitproject.NewExerciseFragment
import com.example.fitproject.R
import com.example.fitproject.adapters.ViewPagerAdapter
import com.example.fitproject.databinding.FragmentMainBinding

import com.example.fitproject.widget.CollapsibleCalendar
import com.google.android.material.navigation.NavigationView
import java.lang.Exception


class MainFragment : Fragment(R.layout.fragment_main) {

    private val NUM_AWESOME_VIEWS = 3
    private var binding: FragmentMainBinding? = null
    lateinit var navigationView: NavigationView
    private var datesList = mutableListOf<String>()
    private var fabClicked = false
    lateinit var collapsibleCalendar: CollapsibleCalendar

    companion object {
        const val userNameKey = "USER_NAME"
        var TAG = "MainActivity"

        @JvmStatic
        fun newInstance(): MainFragment {
            val args = Bundle().apply {
                //putInt (key,value)
                //putString (key, value)
            }
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
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





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postToList()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val c = Calendar.getInstance()
        var day = c.get(Calendar.DAY_OF_MONTH)

        binding = FragmentMainBinding.bind(view)


        binding!!.viewPager2.adapter = ViewPagerAdapter(datesList)
        binding!!.viewPager2.orientation =
            ViewPager2.ORIENTATION_HORIZONTAL
        binding!!.viewPager2.offscreenPageLimit = 3

        binding!!.mainNameTextView.text = arguments?.getString(
            userNameKey
        )

        binding!!.fabMain.setOnClickListener {
            onFabClicked()
        }
        binding!!.fabAddNewExercise.setOnClickListener {
            //todo change to navigation
            var fragment: Fragment? = null
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentClass = NewExerciseFragment
            try {
                fragment = fragmentClass.newInstance() as Fragment
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.containerView, fragment).commit()
            }
        }
        binding!!.fabSecond.setOnClickListener {
            Toast.makeText(activity, "SECOND BUTTON CLICKED", Toast.LENGTH_SHORT).show()
        }
        binding!!.fabThird.setOnClickListener {
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
            binding!!.fabAddNewExercise.visibility = View.VISIBLE
            binding!!.fabSecond.visibility = View.VISIBLE
            binding!!.fabThird.visibility = View.VISIBLE
            binding!!.textView.visibility = View.VISIBLE
            binding!!.textView2.visibility = View.VISIBLE
            binding!!.textView3.visibility = View.VISIBLE
        } else {
            binding!!.fabAddNewExercise.visibility = View.INVISIBLE
            binding!!.fabSecond.visibility = View.INVISIBLE
            binding!!.fabThird.visibility = View.INVISIBLE
            binding!!.textView.visibility = View.INVISIBLE
            binding!!.textView2.visibility = View.INVISIBLE
            binding!!.textView3.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(fabClicked: Boolean) {
        if (!fabClicked) {
            binding!!.fabAddNewExercise.startAnimation(fromBottom)
            binding!!.fabSecond.startAnimation(fromBottom)
            binding!!.fabThird.startAnimation(fromBottom)
            binding!!.textView.startAnimation(fromBottom)
            binding!!.textView2.startAnimation(fromBottom)
            binding!!.textView3.startAnimation(fromBottom)
            binding!!.fabMain.startAnimation(rotateOpen)
        } else {
            binding!!.fabAddNewExercise.startAnimation(toBottom)
            binding!!.fabSecond.startAnimation(toBottom)
            binding!!.fabThird.startAnimation(toBottom)
            binding!!.textView.startAnimation(toBottom)
            binding!!.textView2.startAnimation(toBottom)
            binding!!.textView3.startAnimation(toBottom)
            binding!!.fabMain.startAnimation(rotateClose)
        }
    }

    private fun addToList(date: String) {
        datesList.add(date)
    }

    private fun postToList() {
        for (i in 1..5) {
            addToList("Tile $i")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}