package com.example.fitproject.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import com.example.fitproject.R
import com.example.fitproject.databinding.FragmentNoteBinding
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity


val  KEY = "PREFS_NOTEBOOK"

class NoteFragment : Fragment(R.layout.fragment_note) {

    val sharedPref = activity?.getSharedPreferences(KEY, Context.MODE_PRIVATE)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var binding =  FragmentNoteBinding.bind(view)

                binding.tvNote.setText(getValue())
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onResume() {
        super.onResume()
        var text = view?.findViewById<EditText>(R.id.tv_note)
        saveFromEditText(text?.getText().toString())
    }

    @SuppressLint("CommitPrefEdits", "ApplySharedPref")
    override fun onPause() {
        super.onPause()
        var text = view?.findViewById<EditText>(R.id.tv_note)
        if (text != null){
            saveFromEditText(text.text.toString())
        }
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
    private fun saveFromEditText(text: String) {
        val sharedPref: SharedPreferences? = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        editor?.putString(KEY, text)
        editor?.apply()
    }

    private fun getValue(): String? {
        val sharedPref: SharedPreferences? = activity?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref?.getString(KEY, "") //the 2 argument return default value
    }
}