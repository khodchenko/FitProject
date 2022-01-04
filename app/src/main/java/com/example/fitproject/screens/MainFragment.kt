package com.example.fitproject.screens




import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.fitproject.R
import com.example.fitproject.adapters.DateRecyclerAdapter
import com.example.fitproject.adapters.ViewPagerAdapter
import com.example.fitproject.databinding.FragmentMainBinding
import com.example.fitproject.model.Day
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

@SuppressLint("SimpleDateFormat")
class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null
    private var datesList = mutableListOf<String>()
    private var fabClicked = false
    private var days = mutableListOf<Day>()
    val list: MutableList<Date> = ArrayList()
    val format = SimpleDateFormat("dd/MM/yyyy")
    private var cal: Calendar = Calendar.getInstance()
    private val c  = Calendar.getInstance()
    val currentDay:Date = c.time
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        //crate dates list of viewpager

        // Today
        cal = Calendar.Builder().setDate(2021, 11, 29).build()

        //cal.set(2021,11,12)

        //date recycler view
        createBaseList()
        val adapter =  DateRecyclerAdapter(days)
        val recyclerview = binding!!.dayRecyclerView
        recyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerview.adapter = adapter
        //viewPager2
        binding!!.viewPager2.adapter = ViewPagerAdapter(datesList)
        binding!!.viewPager2.orientation =
            ViewPager2.ORIENTATION_HORIZONTAL
        binding!!.viewPager2.offscreenPageLimit = 3
        addToList()
   //    binding!!.viewPager2.currentItem = date.indexOf(currentDay)//todo

        //main tv
        binding!!.mainNameTextView.text = arguments?.getString(
            userNameKey
        )
        //float action button
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
    private fun addToList() {
        for (i in 1..500) {
            var date:Date = cal.time
            list.add(date)
            cal.add(Calendar.DATE, +1)
            date = cal.time
            datesList.add("$date")
            if (date.toSimpleString() == currentDay.toSimpleString()){
                binding!!.viewPager2.currentItem = datesList.size
            }
        }
    }

    fun Date.toSimpleString() : String {
        val format = SimpleDateFormat("dd/MM/yyy")
        return format.format(this)
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




    private fun createBaseList() {
        var index = 0
        while (index < 30){
            days.add(Day(index+1, "MON"))
            index++
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}